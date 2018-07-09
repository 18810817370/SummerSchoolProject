package com.example.demo.dao;

import com.example.demo.entity.Proposal;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface ProposalDAO {

    @Select(value = "SELECT * FROM proposal")
    List<Proposal> getAllproposal();

    @Select(value = "SELECT * FROM proposal WHERE proposal.status = 'PASS'")
    List<Proposal> getPassproposal();

    @Insert(value = "INSERT INTO proposal (proposal.`ppname`,proposal.`author`,proposal.`ppcontent`)\n" +
            "VALUE(#{Proposal.ppname},#{User.username},#{Proposal.ppcontent})")
    int insert(@Param("Proposal") Proposal proposal,@Param("User")User user);

    @Delete(value = "DELETE from proposal WHERE proposal.ppid = #{ppid}")
    int delete(Proposal proposal);

    @Update(value = "UPDATE proposal SET proposal.ppname = #{ppname}，proposal.ppcontent = #{ppcontent} WHERE proposal.ppid = #{ppid}")
    int update(Proposal proposal);

    @Update(value = "UPDATE proposal SET proposal.status = 'PASS' WHERE proposal.ppid = #{ppid}")
    int pass(Proposal proposal);

    @Update(value = "UPDATE proposal SET proposal.vote = proposal.vote+1 WHERE proposal.ppid= #{ppid}")
    int vote(Proposal proposal);

    @Update(value = "UPDATE proposal SET proposal.disvote = proposal.disvote+1 WHERE proposal.ppid= #{ppid}")
    int disvote(Proposal proposal);
}
