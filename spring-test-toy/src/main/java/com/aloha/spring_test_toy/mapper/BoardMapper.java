package com.aloha.spring_test_toy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aloha.spring_test_toy.domain.Board;

@Mapper
public interface BoardMapper {

    // 목록
    public List<Board> list() throws Exception;
    // 조회
    public Board read(int no) throws Exception;
    // 등록
    public int insert(Board board) throws Exception;
    // 수정
    public int update(Board board) throws Exception;
    // 삭제
    public int delete (int no) throws Exception;


}
