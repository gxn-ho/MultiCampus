package com.score.service;

import java.util.List;

import com.score.dto.Score;

public interface ScoreService {
	public List<Score> getAll();
	public Score getOne(String name);
	public int insert(Score s);
	public int delete(String name);
	public int update(Score s);
}
