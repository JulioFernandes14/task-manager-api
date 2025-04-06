package br.com.task.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.task.entity.Task;
import br.com.task.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	public Task saveTask(Task task) throws Exception {
		try {
			Task resp = taskRepository.save(task);
			return resp;
		}catch (Exception e) {
			throw new Exception("Error: " + e);
		}
	}
	
	public List<Task> findAll() throws Exception {
		try {
			return taskRepository.findAll();
		}catch (Exception ex) {
			throw new Exception("Error: " + ex);
		}
	}
	
	public Task updateById(Task task) throws Exception {
		
		try {
			Optional<Task> taskUpdate = taskRepository.findById(task.getId());
			
			if (taskUpdate.isPresent()) {
				return taskRepository.save(task);
			}
			
			throw new Exception("Id não encontrado");
			
		}catch(Exception ex) {
			throw new Exception("Error: Dados não encontrados");
		}
		
	}
	
	public void deleteById(Long id) throws Exception {
		
		try {
			Optional<Task> taskDelete = taskRepository.findById(id);
			
			if (taskDelete.isEmpty()) {
				throw new Exception("Id não encontrado");
			}
			
			taskRepository.deleteById(id);
			
		}catch(Exception ex) {
			throw new Exception("Error: Dados não encontrados");
		}
		
	}
	
	public Map<String, Long> getTaskCountByStatus() throws Exception {
	    try {
	        List<Object[]> results = taskRepository.countTasksByStatus();
	        Map<String, Long> statusCountMap = new HashMap<>();

	        for (Object[] result : results) {
	            String status = (String) result[0];
	            Long count = (Long) result[1];
	            statusCountMap.put(status, count);
	        }

	        return statusCountMap;

	    } catch (Exception e) {
	        throw new Exception("Erro ao contar tarefas por status: " + e.getMessage());
	    }
	}

	
}
