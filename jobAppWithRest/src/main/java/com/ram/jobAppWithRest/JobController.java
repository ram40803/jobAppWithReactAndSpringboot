package com.ram.jobAppWithRest;


import com.ram.jobAppWithRest.model.JobPost;
import com.ram.jobAppWithRest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//public class JobController {
//
//    @Autowired
//    private JobService service;
//
//    @GetMapping("all")
//    @ResponseBody
//    public List<JobPost> getAllPost(){
//        return service.getAllJobs();
//    }
//}

//****************************  OR  **********************************

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class JobController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    public List<JobPost> getAllPost(){
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJobPost(@PathVariable("postId") int id){
        return service.getJobPost(id);
    }

    @PostMapping("jobPost")
    public void addJob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJobPost(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId){
        service.deteteJob(postId);
        return "Deleted";
    }
}


