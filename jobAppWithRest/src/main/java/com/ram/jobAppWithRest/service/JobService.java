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
        repo.save(jobPost);
    }

    public List<JobPost> getAllJobs(){
        return repo.findAll();
    }

    public JobPost getJobPost(int id) {
        return repo.findById(id).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public void deteteJob(int postId) {
        repo.deleteById(postId);
    }

    public List<JobPost> getJobPostByKeyword(String keyword) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
    }
}
