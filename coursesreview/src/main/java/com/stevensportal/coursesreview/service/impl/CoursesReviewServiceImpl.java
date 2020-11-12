package com.stevensportal.coursesreview.service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stevensportal.coursesreview.contract.response.CourseProfessorMappingDTO;
import com.stevensportal.coursesreview.contract.response.CourseResponseDTO;
import com.stevensportal.coursesreview.contract.response.CoursesResponseDTO;
import com.stevensportal.coursesreview.contract.response.LoginResponseDTO;
import com.stevensportal.coursesreview.contract.response.ProfessorResponseDTO;
import com.stevensportal.coursesreview.contract.response.StudentMajorCourseMappingDTO;
import com.stevensportal.coursesreview.contract.response.StudentResponseDTO;
import com.stevensportal.coursesreview.contract.response.base.ErrorDTO;
import com.stevensportal.coursesreview.entity.Course;
import com.stevensportal.coursesreview.entity.Major;
import com.stevensportal.coursesreview.entity.Professor;
import com.stevensportal.coursesreview.entity.Student;
import com.stevensportal.coursesreview.enumeration.ErrorResponseEnum;
import com.stevensportal.coursesreview.repository.CourseRepository;
import com.stevensportal.coursesreview.repository.MajorRepository;
import com.stevensportal.coursesreview.repository.StudentRepository;
import com.stevensportal.coursesreview.service.CoursesReviewService;

import java.util.*;

/**
 * @author staneja14
 *
 */
@Service
public class CoursesReviewServiceImpl implements CoursesReviewService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	MajorRepository majorRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public LoginResponseDTO verifyUser(String emailId, List<ErrorDTO> errorList) {

		LoginResponseDTO loginResponse = new LoginResponseDTO();
		List<Student> students = (List<Student>) studentRepository.findAll();

		Student matchedStudent = null;
		for (Student student : students) {
			if (student.getEmail().equalsIgnoreCase(emailId)) {
				matchedStudent = student;
				break;
			}
		}

		if (matchedStudent != null) {
			loginResponse.setStudentId(matchedStudent.getStudentId());
		} else {
			errorList.add(new ErrorDTO(ErrorResponseEnum.EMAIL_DOES_NOT_EXIST, emailId));
		}

		return loginResponse;
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public StudentResponseDTO fetchStudentInfo(Integer studentId, List<ErrorDTO> errorList) {

		Optional<Student> optionalStudent = studentRepository.findById(studentId);
		StudentResponseDTO studentResponse = new StudentResponseDTO();

		if (optionalStudent.isEmpty()) {
			errorList.add(new ErrorDTO(ErrorResponseEnum.STUDENT_DOES_NOT_EXIST, String.valueOf(studentId)));
		} else {
			Student student = optionalStudent.get();
			studentResponse.setStudentId(student.getStudentId());
			studentResponse.setName(student.getName());
			studentResponse.setEmailId(student.getEmail());

			Major major = majorRepository.findById(student.getMajorId()).get();
			studentResponse.setMajor(major.getName());
		}

		return studentResponse;
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public CoursesResponseDTO fetchCoursesInfo(Integer studentId, List<ErrorDTO> errorList) {

		CoursesResponseDTO coursesResponse = new CoursesResponseDTO();
		List<CourseResponseDTO> courses = new ArrayList<>();
		coursesResponse.setCourses(courses);

		List<StudentMajorCourseMappingDTO> mappingDto = courseRepository.findCoursesByStudentId(studentId);

		if (CollectionUtils.isEmpty(mappingDto)) {
			errorList.add(new ErrorDTO(ErrorResponseEnum.STUDENT_DOES_NOT_EXIST, String.valueOf(studentId)));
		} else {
			for (StudentMajorCourseMappingDTO studentMajorCourse : mappingDto) {
				CourseResponseDTO courseResp = new CourseResponseDTO();
				Course course = studentMajorCourse.getCourse();
				courseResp.setCourseId(course.getCourseId());
				courseResp.setName(course.getName());
				courseResp.setDescription(course.getDescription());
				courseResp.setRating(course.getRating());
				courseResp.setSemester(course.getSemester());
				courseResp.setTeachingMode(course.getTeachingMode());
				courses.add(courseResp);
			}
		}

		return coursesResponse;
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public ProfessorResponseDTO fetchProfessorInfo(Integer courseId, List<ErrorDTO> errorList) {

		ProfessorResponseDTO professorResponse = new ProfessorResponseDTO();

		List<CourseProfessorMappingDTO> mappingDto = courseRepository.findProfessorByCourseId(courseId);

		if (CollectionUtils.isEmpty(mappingDto)) {
			errorList.add(new ErrorDTO(ErrorResponseEnum.COURSE_DOES_NOT_EXIST, String.valueOf(courseId)));
		} else {
			for (CourseProfessorMappingDTO courseProfessor : mappingDto) {
				Professor professor = courseProfessor.getProfessor();
				professorResponse.setProfId(professor.getProfId());
				professorResponse.setName(professor.getName());
				professorResponse.setEducation(professor.getEducation());
				professorResponse.setRating(professor.getRating());
			}
		}

		return professorResponse;
	}
}
