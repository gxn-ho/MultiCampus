package com.boot.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.mvc.model.biz.Askbiz;
import com.boot.mvc.model.biz.BoardMemberBiz;
import com.boot.mvc.model.biz.MemberBiz;
import com.boot.mvc.model.biz.Mybiz1;
import com.boot.mvc.model.dto.AskDto;
import com.boot.mvc.model.dto.BoardMemberDto;
import com.boot.mvc.model.dto.MyDto;

@Controller
@RequestMapping("/board")
public class SemiController {

	@Autowired
	private Mybiz1 myBiz;
	
	//member 테이블에서 받아와야 한다. 회원가입/로그인 시에 필요로 하는 dto,biz로 이름 변경해주세용
	@Autowired
	private MemberBiz mbBiz;
	
	@Autowired
	private Askbiz askBiz;

	@Autowired
	private BoardMemberBiz memberBiz;

	MyDto dto = new MyDto();
	AskDto askdto = new AskDto();
	BoardMemberDto memberdto = new BoardMemberDto();

	@GetMapping("/studyroommake")
	public String studyroommake() {
		return "studyroommake";
	}

	@PostMapping("/makeform")
	public String insert(HttpSession session, String title, String category, int people_num,
			String description) {
		
		String userid = (String) session.getAttribute("memberid"); //팀장의 아이디로 userid
		String usernm = (String) session.getAttribute("membernm"); //팀장의 이름으로 usernm
		
		dto.setTitle(title);
		dto.setCategory(category);
		dto.setPeople_num(people_num);
		dto.setDescription(description);
		myBiz.insert(dto, userid); //팀장의 아이디가 들어감
		
		MyDto dt = myBiz.selectOne(title); 
		session.setAttribute("no", dt.getNo());  //왜 여기에 넣었냐면 스터디룸 생성 후에는 바로 detail로 넘어가서 목록에서 받아올 수가 없어서 넣음
		
		session.setAttribute("title", dto.getTitle()); // 스터디룸 이름
		session.setAttribute("people_num", dto.getPeople_num());
		
		session.setAttribute("description", dto.getDescription());
		
		
		session.setAttribute("team_id", userid); //팀장의 아이디를 저장
		session.setAttribute("team_nm", usernm); //팀장의 이름을 저장
	
		//실패 따위 없어요
//		if (myBiz.insert(dto, userid) > 0) {
//			return "redirect:/board/studyroomdetail";
//		} else {
//			return "redirect:/board/studyroommake";
//		}
		
		//return "redirect:/board/studyroomdetail"; 진하님 여기 스터디룸 목록으로 가는 주소로 변경 부탁드려욤
	}

	
	@GetMapping("/studyroomdetail")
	public String studyroomdetail(HttpSession session, Model model, int room_id) { //no를 room_id로 받았어요
		
		
		List<BoardMemberDto> member = memberBiz.selectOne(room_id);
		
		//session.setAttribute("member", member.size());

		model.addAttribute("room_id", room_id); //hidden으로 이제 계속 받을 것임.
		model.addAttribute("userid", session.getAttribute("team_nm")); //팀장 이름
		model.addAttribute("member", member.size());
		
		MyDto dd = myBiz.selectOne(room_id);
		model.addAttribute("title", dd.getTitle());
		model.addAttribute("people_num", dd.getPeople_num());
		model.addAttribute("description", dd.getPeople_num());

		return "studyroomdetail";
	}

	
	@GetMapping("/studyroomquestion")
	public String studyroomquestion(HttpSession session, Model model, int room_id) {

		List<AskDto> ask = askBiz.selectList();
		
		List<BoardMemberDto> member = memberBiz.selectOne(room_id);
		model.addAttribute("member", member.size());
		
		
		model.addAttribute("room_id", room_id);
		model.addAttribute("list", ask);
		model.addAttribute("userid", session.getAttribute("team_nm"));
		
		
		MyDto dd = myBiz.selectOne(room_id);
		model.addAttribute("title", dd.getTitle());
		model.addAttribute("people_num", dd.getPeople_num());
		
		return "studyroomquestion";
	}

	@PostMapping("/question") // 질문을 insert 해주기
	public String questionform(HttpSession session, Model model, String question, int room_id) {
		
		List<BoardMemberDto> member = memberBiz.selectOne(room_id);
		model.addAttribute("member", member.size());
		
		model.addAttribute("room_id", room_id);
		
		model.addAttribute("userid", session.getAttribute("team_nm")); //팀장 아이디
		
		model.addAttribute("user", session.getAttribute("memberid")); //유저 아이디 가져오기
		
		askdto.setUser_id((String)session.getAttribute("memberid"));
		askdto.setContent(question);
		askBiz.insert(askdto, (String)session.getAttribute("memberid"), (int)session.getAttribute("no"));

		List<AskDto> ask = askBiz.selectList();

		MyDto dd = myBiz.selectOne(room_id);
		model.addAttribute("title", dd.getTitle());
		model.addAttribute("people_num", dd.getPeople_num());
		model.addAttribute("list", ask);
		return "studyroomquestion";
	}

	@PostMapping("/questionupdate")
	public String questionupdate(HttpSession session, Model model, int no, String reply, int room_id) {
		model.addAttribute("room_id", room_id);
		//여기서 no는 질문 번호

		askBiz.update(no, reply);
		List<AskDto> ask = askBiz.selectList();
		
		List<BoardMemberDto> member = memberBiz.selectOne(room_id);
		model.addAttribute("member", member.size());
		
		//model.addAttribute("user", session.getAttribute("memberid")); //그냥 저장된 userid 가져오는 거(팀장이 아니더라도 됨)
		model.addAttribute("list", ask);
		model.addAttribute("no", no); //질문 번호 
		model.addAttribute("reply", reply);
		
		model.addAttribute("userid", session.getAttribute("team_nm")); //팀장 아이디
	
		MyDto dd = myBiz.selectOne(room_id);
		model.addAttribute("title", dd.getTitle());
		model.addAttribute("people_num", dd.getPeople_num());
		
		return "studyroomquestion";
	}

	
	@PostMapping("/join")
	public String join(HttpSession session, Model model, String comment, int room_id) {
		// memberdto.setRoom_id(room_id);
		// memberBiz.insert(memberdto); //로그인되어있는 id 확인해서 insert 해주기

		
		//방 만든 후에 로그아웃 하고 해야 
		memberdto.setNo((int)session.getAttribute("no")); //방번호 넘겨주기
		memberdto.setUser_id((String)session.getAttribute("memberid")); //참여하기 버튼 누른 유저 아이디 
		memberdto.setUser_nm((String)session.getAttribute("membernm")); //참여하기 버튼 누른 유저 이름 
		
		memberBiz.insert(memberdto);
		
		List<BoardMemberDto> memsel = memberBiz.selectOne(room_id);
		 model.addAttribute("room_id", room_id);

		// dto.getPeople_num을 session으로 바꾼다면?
		// 일단 확인을 위함이고 나중에는 룸 id나 스터디 이름을 통해서 인원 확인해주기

		if (memsel.size() == (int) session.getAttribute("people_num"))
			model.addAttribute("member", session.getAttribute("member"));
		else {
			model.addAttribute("member", (int) session.getAttribute("member") + 1);
		}

		model.addAttribute("memsel", memsel);
		
		model.addAttribute("userid", session.getAttribute("team_nm")); //방장 이름에 들어가는 userid
		MyDto dd = myBiz.selectOne(room_id);
		model.addAttribute("title", dd.getTitle());
		model.addAttribute("people_num", dd.getPeople_num());
		model.addAttribute("member", memsel.size());

		if (comment.equals("detail"))
			return "studyroomdetail";
		else {
			return "studyroomquestion";
		}
	}

	@GetMapping("/studyroomsetting")
	public String studyroomsetting(HttpSession session, Model model, int room_id) {
		List<BoardMemberDto> member = memberBiz.selectOne(room_id);
		MyDto bd = myBiz.selectOne((String)session.getAttribute("title"));
		
		model.addAttribute("userid", session.getAttribute("team_nm"));
		model.addAttribute("room_id", room_id);
		model.addAttribute("member", member); //스터디룸에 속한 멤버들
		
		MyDto dd = myBiz.selectOne(room_id);
		model.addAttribute("studyroom", dd.getDescription()); //설명. 만약에 실행 안 되면 MyDto에서 불러오기
		model.addAttribute("member_num", member.size()); //인원수
		
		model.addAttribute("title", dd.getTitle());
		model.addAttribute("people_num", dd.getPeople_num());
		return "studyroomsetting";
	}

	@PostMapping("/setupdate")
	public String setupdate(HttpSession session, Model model, String description, int room_id) {
		List<BoardMemberDto> member = memberBiz.selectOne(room_id);
		myBiz.update(description, room_id);
		
		//session.setAttribute("description", description);
		
		model.addAttribute("member", member);
		model.addAttribute("studyroom", description);
		model.addAttribute("member_num", member.size()); //인원수
		
		model.addAttribute("room_id", room_id);
		model.addAttribute("userid", session.getAttribute("team_nm"));
		model.addAttribute("member_num", session.getAttribute("member"));
		MyDto dd = myBiz.selectOne(room_id);
		model.addAttribute("title", dd.getTitle());
		model.addAttribute("people_num", dd.getPeople_num());
		return "studyroomsetting";
	}

	
	
//	@PostMapping("/memberdelete")
//	public String memberupdate(HttpSession session, Model model, String user_id) {
//		
//		
//		model.addAttribute("studyroom", session.getAttribute("description"));
//		model.addAttribute("userid", session.getAttribute("userid"));
//		model.addAttribute("member", session.getAttribute("member"));
//		model.addAttribute("title", session.getAttribute("title"));
//		model.addAttribute("people_num", session.getAttribute("people_num"));
//		return "studyroomsetting";
//	}
	
	
	/*만약에 현재 인원수 컬럼 추가해서 하는 경우*/
//	@PostMapping("/join")
//	public String join(HttpSession session, Model model, String comment) {
//		// memberdto.setRoom_id(room_id);
//		// memberBiz.insert(memberdto); //로그인되어있는 id 확인해서 insert 해주기
//
//		memberdto.setRoom_id(room_id);
//		memberdto.setUser_id(userid);
//		memberdto.setUser_nm("테스트");
//		memberBiz.insert(memberdto);
//
//		
//		List<BoardMemberDto> memsel = memberBiz.selectOne(room_id);
//		myBiz.update(memsel.size(), room_id);
	
//		// model.addAttribute("room_id", room_id);
//
//		// dto.getPeople_num을 session으로 바꾼다면?
//		// 일단 확인을 위함이고 나중에는 룸 id나 스터디 이름을 통해서 인원 확인해주기
//
//		if (memsel.size() == (int) session.getAttribute("people_num"))
//			model.addAttribute("member", session.getAttribute("member"));
//		else {
//			model.addAttribute("member", (int) session.getAttribute("member") + 1);
//		}
//
//		model.addAttribute("memsel", memsel);
//		model.addAttribute("userid", session.getAttribute("userid"));
//		model.addAttribute("title", session.getAttribute("title"));
//		model.addAttribute("people_num", session.getAttribute("people_num"));
//
//		if (comment.equals("detail"))
//			return "studyroomdetail";
//		else {
//			return "studyroomquestion";
//		}
//	}
	

}
