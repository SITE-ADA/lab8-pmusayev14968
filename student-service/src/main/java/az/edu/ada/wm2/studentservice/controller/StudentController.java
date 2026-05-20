package az.edu.ada.wm2.studentservice.controller;

import az.edu.ada.wm2.studentservice.model.dto.StudentRequestDto;
import az.edu.ada.wm2.studentservice.model.dto.StudentResponseDto;
import az.edu.ada.wm2.studentservice.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
@Tag(
        name = "Tələbələr",
        description = "Tələbələrin idarə olunması üçün endpointlər"
)
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    @Operation(
            summary = "Tələbə yarat",
            description = "Sistemdə yeni tələbə yaradılır"
    )
    public ResponseEntity<StudentResponseDto> createStudent(
            @Valid @RequestBody StudentRequestDto requestDto
    ) {
        StudentResponseDto createdStudent = studentService.createStudent(requestDto);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(
            summary = "Bütün tələbələri gətir",
            description = "Sistemdə mövcud olan bütün tələbələrin siyahısını qaytarır"
    )
    public ResponseEntity<List<StudentResponseDto>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "ID ilə tələbə",
            description = "Verilmiş ID-yə uyğun tələbə məlumatını qaytarır"
    )
    public ResponseEntity<StudentResponseDto> getStudentById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Tələbəni yenilə",
            description = "Mövcud tələbənin məlumatlarını yeniləyir"
    )
    public ResponseEntity<StudentResponseDto> updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentRequestDto requestDto
    ) {
        return ResponseEntity.ok(studentService.updateStudent(id, requestDto));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Tələbəni sil",
            description = "Verilmiş ID-yə uyğun tələbəni sistemdən silir"
    )
    public ResponseEntity<Void> deleteStudent(
            @PathVariable Long id
    ) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    @Operation(
            summary = "Tələbə axtarışı",
            description = "Ad və ya soyad üzrə tələbələri qismən uyğunluqla axtarır"
    )
    public List<StudentResponseDto> searchStudentsByName(
            @RequestParam String name
    ) {
        return studentService.searchStudentsByName(name);
    }
}