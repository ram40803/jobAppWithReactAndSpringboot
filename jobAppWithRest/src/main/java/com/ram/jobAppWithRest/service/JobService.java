package com.ram.jobAppWithRest.service;


import com.ram.jobAppWithRest.model.JobPost;
import com.ram.jobAppWithRest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost){
        repo.addjob(jobPost);
    }

    public List<JobPost> getAllJobs(){
        return repo.getAllJobs();
    }

    public JobPost getJobPost(int id) {
        return repo.getJobPost(id);
    }

    public void updateJob(JobPost jobPost) {
        repo.updateJob(jobPost);
    }

    public void deteteJob(int postId) {
        repo.deleteJob(postId);
    }
}
