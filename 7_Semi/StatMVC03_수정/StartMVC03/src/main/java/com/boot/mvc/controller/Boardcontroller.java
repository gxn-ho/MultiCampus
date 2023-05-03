package com.boot.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.boot.mvc.model.biz.BoardBiz;
import com.boot.mvc.model.dto.BoardDto;
import com.boot.mvc.model.dto.Pagination;
import com.boot.mvc.model.mapper.BoardMapper;

@Controller
@RequestMapping("/board")
public class Boardcontroller {
	
	@Autowired
	private BoardBiz biz;
	@Autowired
	private BoardMapper map;
	
	@GetMapping("/list")
	public String selectList(Model model, @RequestParam(defaultValue = "1") int page) {
		
	    // 총 게시물 수 
	    int totalListCnt = map.findAllCnt();
	    Pagination pagination = new Pagination(totalListCnt, page);
	    int startIndex = pagination.getStartIndex();
	    int pageSize = pagination.getPageSize();
	    List<BoardDto> boardList = map.findListPaging(startIndex, pageSize);
	    
	    model.addAttribute("boardList", boardList);
	    model.addAttribute("pagination", pagination);
		
		return "boardlist";
	}
	
	@GetMapping("/writeform")
	public String writeForm() {	
		return "boardwrite";
	}
	
	@PostMapping("/write")
	public String write(BoardDto dto, Model model, @RequestParam(name = "file", required = false) MultipartFile file) {
	    try {
	    	if (file != null && !file.isEmpty()) {
	            biz.write(dto, file);
	        } else {
	            biz.write(dto, null);
	        }
	    	model.addAttribute("message", "글 작성이 완료되었습니다.");
	    	model.addAttribute("searchUrl", "/board/list");
	    	return "message";
	    } catch (Exception e) {
	        e.printStackTrace();
	        model.addAttribute("message", "글 작성 중 오류가 발생했습니다.");
	        model.addAttribute("searchUrl", "/board/list");
	        return "message";
	    }
	} 
	
	@GetMapping("/view")
	public String selectOne(Model model, int qna_no) {
	// 해당 게시물의 조회수를 1 증가시킵니다.
	biz.updateViewCount(qna_no);
	model.addAttribute("dto", biz.selectOne(qna_no));
	return "boardview";
	}
	
	@GetMapping("/updateform")
	public String updateForm(Model model, int qna_no) {
		model.addAttribute("dto", biz.selectOne(qna_no));
		return "boardupdate";
	}
	
	@PostMapping("/update")
	public String update(BoardDto dto, Model model) {
		model.addAttribute("message","글 수정이 완료되었습니다");
		model.addAttribute("searchUrl","/board/list");
		if(biz.update(dto) > 0) {
			return "message";
		}else {
			return "redirect:/board/updateform?qna_no=" + dto.getQna_no();
		}
	}
		
	@GetMapping("/delete")
	public String delete(int qna_no, Model model) {
		model.addAttribute("message","삭제가 완료되었습니다");
		model.addAttribute("searchUrl","/board/list");
	    if(biz.delete(qna_no) > 0) {
	        return "message";
	    } else {
	        return "redirect:/board/view?qna_no=" + qna_no;
	    }
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
