package az.edu.ada.wm2.courseservice.model.dto;

import java.util.List;

public record StudentCoursesResponseDto(
        Long studentId,
        String firstName,
        String lastName,
        List<CourseResponseDto> courses
) {
}