import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class FillFormWithPageObjectTest {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Mike",
            lastName = "Mo",
            emailAddress = "test@email.com",
            genderValue = "Male",
            phoneNumber = "9987654321",
            dayOfBirthDay = "22",
            monthOfBirthDay = "September",
            yearOfBirthDay = "1988",
            subjectChar = "E",
            hobbieValue = "Music",
            namePicture = "test.jpeg",
            fullAddress = "112233, Какая-то область, г. Какой-то, ул. Какая-то д.3, кв.3",
            nameState = "NCR",
            nameCity = "Delhi";


    @Test
    void fillFormWithAllFieldTest(){
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(emailAddress)
                .setGender(genderValue)
                .setUserPhoneNumber(phoneNumber)
                .setDateOfBirthDay(dayOfBirthDay,monthOfBirthDay,yearOfBirthDay)
                .setSubjectInput(subjectChar)
                .setHobbie(hobbieValue)
                .setUploadPicture(namePicture)
                .setAddress(fullAddress)
                .setState(nameState)
                .setCity(nameCity)
                .clickSubmit()
                .checkModalWindow()
                .checkTableValue("Student Name",firstName + " " + lastName)
                .checkTableValue("Student Email",emailAddress)
                .checkTableValue("Gender",genderValue)
                .checkTableValue("Mobile",phoneNumber)
                .checkTableValue("Date of Birth",dayOfBirthDay + " " + monthOfBirthDay + "," + yearOfBirthDay)
                .checkTableValue("Subjects",subjectChar)
                .checkTableValue("Hobbies",hobbieValue)
                .checkTableValue("Picture",namePicture)
                .checkTableValue("Address",fullAddress)
                .checkTableValue("State and City",nameState + " " + nameCity);
    }

    @Test
    void fillFormWithOnlyRequiredFieldTest(){
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(genderValue)
                .setUserPhoneNumber(phoneNumber)
                .setDateOfBirthDay(dayOfBirthDay,monthOfBirthDay,yearOfBirthDay)
                .clickSubmit()
                .checkModalWindow()
                .checkTableValue("Student Name",firstName + " " + lastName)
                .checkTableValue("Student Email","")
                .checkTableValue("Gender",genderValue)
                .checkTableValue("Mobile",phoneNumber)
                .checkTableValue("Date of Birth",dayOfBirthDay + " " + monthOfBirthDay + "," + yearOfBirthDay)
                .checkTableValue("Subjects","")
                .checkTableValue("Hobbies","")
                .checkTableValue("Picture","")
                .checkTableValue("Address","")
                .checkTableValue("State and City","");
    }

    @Test
    void notFillFormRequiredFieldTest(){
        registrationPage.openPage()
                .clickSubmit()
                .checkValidation()
                .checkNotVisibleModalWindow();

    }
}