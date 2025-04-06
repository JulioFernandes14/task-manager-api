package br.com.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.task.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

	@Query(value = """
		    SELECT 
		        CASE 
		            WHEN LOWER(status) = 'em progresso' THEN 'emProgresso'
		            WHEN LOWER(status) = 'paralisada' THEN 'paralisada'
		            WHEN LOWER(status) = 'pendente' THEN 'pendente'
		            WHEN LOWER(status) = 'concluído' OR LOWER(status) = 'concluido' THEN 'concluido'
		            ELSE 'outro'
		        END as statusKey,
		        COUNT(*) as total
		    FROM task
		    GROUP BY statusKey
		    """, nativeQuery = true)
	List<Object[]> countTasksByStatus();
	
}
