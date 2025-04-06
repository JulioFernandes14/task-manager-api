package br.com.task.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.task.entity.Task;
import br.com.task.service.TaskService;

@CrossOrigin(origins = "http://localhost:4200")
@ResponseBody
@RestController
@RequestMapping("task-manager")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@PostMapping("create")
	public ResponseEntity<?> create(@RequestBody Task task) {
		try {
			return ResponseEntity.status(200).body(taskService.saveTask(task));
		}catch(Exception ex) {
			return ResponseEntity.status(500).body("Error: " + ex);
		}
	}
	
	@GetMapping("list")
	public ResponseEntity<?> findAll() {
		try {
			return ResponseEntity.status(200).body(taskService.findAll());
		}catch(Exception ex) {
			return ResponseEntity.status(500).body("Error: " + ex);
		}
	}
	
	@PutMapping("update")
	public ResponseEntity<?> update(@RequestBody Task task) throws Exception {
		try {
			return ResponseEntity.status(200).body(taskService.updateById(task));
		}catch(Exception ex) {
			return ResponseEntity.status(500).body("Error: " + ex);
		}
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
		try {
			taskService.deleteById(id);
			return ResponseEntity.status(200).build();
		}catch (Exception ex) {
			return ResponseEntity.status(500).body("Error: " + ex);
		}
	}
	
	 @GetMapping("/status-count")
	 public ResponseEntity<Map<String, Long>> getStatusCount() {
		 try {
			 Map<String, Long> response = taskService.getTaskCountByStatus();
	         return ResponseEntity.ok(response);
	     }catch (Exception e) {
	    	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	     }
	 }
	
}
