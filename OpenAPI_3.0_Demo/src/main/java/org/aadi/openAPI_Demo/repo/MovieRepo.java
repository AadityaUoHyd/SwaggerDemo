package org.aadi.openAPI_Demo.repo;

import org.aadi.openAPI_Demo.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface MovieRepo extends JpaRepository<Movie,Long> {
}
