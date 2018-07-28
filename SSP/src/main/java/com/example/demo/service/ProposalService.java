package com.example.demo.service;

import com.example.demo.entity.Proposal;
import com.example.demo.entity.User;

import java.util.List;

public interface ProposalService {

    List<Proposal> getAllProposal();

    List<Proposal> getPassProposal();

    boolean insert(Proposal proposal,User user);

    boolean delete(Proposal proposal);

    boolean update(Proposal proposal);

    boolean pass(Proposal proposal);

    boolean vote(Proposal proposal);

    boolean disvote(Proposal proposal);
}
