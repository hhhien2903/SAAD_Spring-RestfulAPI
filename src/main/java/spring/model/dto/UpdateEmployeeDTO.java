package spring.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeDTO {

	@NotBlank(message = "First name is not blank")
	private String firstName;
	@NotBlank(message = "First name is not blank")
	private String lastName;
	@NotBlank(message = "Email is not blank")
	@Email(message = "Email should be valid")
	private String email;
}
