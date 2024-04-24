package ru.martinov.connector.quartz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.quartz.JobDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.martinov.connector.quartz.model.JobDescriptor;

@RestController
@RequestMapping("/quartz")
@Tag(name = "QuartzController", description = "Для работы с джобами quartz")
public interface QuartzController {

    @GetMapping(path = "/groups/jobs")
    ResponseEntity<JobDescriptor> findAllJobs();

    @PostMapping(path = "/groups/{group}/jobs")
    ResponseEntity<JobDescriptor> createJob(@PathVariable String group,
                                            @RequestBody JobDescriptor descriptor);

    @GetMapping(path = "/groups/{group}/jobs/{name}")
    ResponseEntity<JobDescriptor> findJob(@PathVariable String group,
                                          @PathVariable String name);

    @PutMapping(path = "/groups/{group}/jobs/{name}")
    ResponseEntity<JobDetail> updateJob(@PathVariable String group,
                                        @PathVariable String name,
                                        @RequestBody JobDescriptor descriptor);

    @DeleteMapping(path = "/groups/{group}/jobs/{name}")
    ResponseEntity<Void> deleteJob(@PathVariable String group,
                                          @PathVariable String name);

    @PatchMapping(path = "/groups/{group}/jobs/{name}/pause")
    ResponseEntity<Void> pauseJob(@PathVariable String group,
                                  @PathVariable String name);

    @PatchMapping(path = "/groups/{group}/jobs/{name}/resume")
    ResponseEntity<Void> resumeJob(@PathVariable String group, @PathVariable String name);
}
