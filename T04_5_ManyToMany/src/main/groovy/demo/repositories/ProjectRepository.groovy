package demo.repositories

import demo.models.Project
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by luis on 9/18/15.
 */
interface ProjectRepository extends JpaRepository<Project, Long> {

}