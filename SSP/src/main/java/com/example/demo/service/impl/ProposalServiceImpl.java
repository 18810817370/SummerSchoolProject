package com.example.demo.service.impl;

import com.example.demo.dao.ProposalDAO;
import com.example.demo.entity.User;
import com.example.demo.service.ProposalService;
import java.util.List;
import com.example.demo.entity.Proposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProposalServiceImpl implements ProposalService {

    @Autowired
    private ProposalDAO proposalDAO;

    @Override
    public List<Proposal> getAllProposal(){
        return proposalDAO.getAllproposal();
    }

    @Override
    public  List<Proposal> getPassProposal(){
        return proposalDAO.getPassproposal();
    }

    @Override
    public boolean insert(Proposal proposal,User user){
        if( null == proposal){
            return false;
        }
        proposalDAO.insert(proposal,user);
        return true;
    }

    @Override
    public boolean delete(Proposal proposal){
        if( null == proposal){
            return false;
        }
        proposalDAO.delete(proposal);
        return true;
    }

    @Override
    public boolean update(Proposal proposal){
        if( null == proposal){
            return false;
        }
        proposalDAO.update(proposal);
        return true;
    }


    @Override
    public  boolean pass(Proposal proposal){
        if( null == proposal){
            return false;
        }
        proposalDAO.pass(proposal);
        return true;
    }

    @Override
    public boolean vote(Proposal proposal){
        if( null == proposal){
            return false;
        }
        proposalDAO.vote(proposal);
        return true;
    }

    @Override
    public boolean disvote(Proposal proposal){
        if( null == proposal){
            return false;
        }
        proposalDAO.disvote(proposal);
        return true;
    }
}