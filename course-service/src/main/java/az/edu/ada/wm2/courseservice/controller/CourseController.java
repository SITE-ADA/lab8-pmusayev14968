package az.edu.ada.wm2.courseservice.controller;

import az.edu.ada.wm2.courseservice.model.dto.*;
import az.edu.ada.wm2.courseservice.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
@Tag(
        name = "Kurslar",
        description = "Kursların idarə olunması və tələbə qeydiyyatı üçün endpointlər"
)
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    @Operation(
            summary = "Kurs yarat",
            description = "Sistemdə yeni kurs yaradır"
    )
    public ResponseEntity<CourseResponseDto> createCourse(
            @Valid @RequestBody CourseRequestDto requestDto
    ) {
        CourseResponseDto createdCourse = courseService.createCourse(requestDto);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(
            summary = "Bütün kursları gətir",
            description = "Sistemdə mövcud olan bütün kursların siyahısını qaytarır"
    )
    public ResponseEntity<List<CourseResponseDto>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "ID ilə kurs",
            description = "Verilmiş ID-yə uyğun kurs məlumatını qaytarır"
    )
    public ResponseEntity<CourseResponseDto> getCourseById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Kursu yenilə",
            description = "Mövcud kursun məlumatlarını yeniləyir"
    )
    public ResponseEntity<CourseResponseDto> updateCourse(
            @PathVariable Long id,
            @Valid @RequestBody CourseRequestDto requestDto
    ) {
        return ResponseEntity.ok(courseService.updateCourse(id, requestDto));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Kursu sil",
            description = "Verilmiş ID-yə uyğun kursu sistemdən silir"
    )
    public ResponseEntity<Void> deleteCourse(
            @PathVariable Long id
    ) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{courseId}/students/{studentId}")
    @Operation(
            summary = "Tələbəni kursa qeyd et",
            description = "Tələbəni kursa yazır və student-service vasitəsilə doğrulama aparır"
    )
    public ResponseEntity<EnrollmentResponseDto> enrollStudent(
            @PathVariable Long courseId,
            @PathVariable Long studentId
    ) {
        EnrollmentResponseDto responseDto =
                courseService.enrollStudent(courseId, studentId);

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{courseId}/students")
    @Operation(
            summary = "Kursa yazılmış tələbələr",
            description = "Verilmiş kursa aid olan tələbələri qaytarır (student-service ilə əlaqəli)"
    )
    public ResponseEntity<CourseStudentsResponseDto> getCourseStudents(
            @PathVariable Long courseId
    ) {
        return ResponseEntity.ok(courseService.getCourseStudents(courseId));
    }

    @GetMapping("/students/search")
    @Operation(
            summary = "Tələbəyə görə kurslar",
            description = "Tələbə adına görə onun qeydiyyatda olduğu kursları qaytarır"
    )
    public ResponseEntity<List<StudentCoursesResponseDto>> getCoursesByStudentName(
            @RequestParam String name
    ) {
        return ResponseEntity.ok(
                courseService.getCoursesByStudentName(name)
        );
    }
}