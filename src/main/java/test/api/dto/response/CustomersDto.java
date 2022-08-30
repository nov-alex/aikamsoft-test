package test.api.dto.response;

import lombok.Data;

@Data
public class CustomersDto {
    private String lastName;
    private String firstName;
    private CustomersDto() {
    }
    public String getLastName() {
        return lastName;
    }
    public CustomersDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public String getFirstName() {
        return firstName;
    }
    public CustomersDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    public static CustomersDto.Builder newBuilder(CustomersDto customersDto) {
        return new CustomersDto().new Builder(customersDto);
    }
    public final class Builder {
        private Builder(CustomersDto customersDto) {
            CustomersDto.this.setLastName(customersDto.getLastName());
            // тут мин необходимые методы
        }
        // эти методы можно вызывать дополнительно
        public CustomersDto.Builder setFirstName(String firstName) {
            CustomersDto.this.setFirstName(firstName);
            return this;
        }
        public CustomersDto build() {
            return CustomersDto.this;
        }
    }
}
