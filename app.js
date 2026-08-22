const form = document.getElementById("registration-form");

const nameInput = document.getElementById("name");
const idInput = document.getElementById("student-id");
const emailInput = document.getElementById("email");
const courseInput = document.getElementById("course");
const yearInput = document.getElementById("year");
const mobileInput = document.getElementById("mobile");
const birthDateInput = document.getElementById("birth-date");
const passwordInput = document.getElementById("password");
const confirmPasswordInput = document.getElementById("confirm-password");
const termsInput = document.getElementById("terms");

const nameError = document.getElementById("name-error");
const idError = document.getElementById("student-id-error");
const emailError = document.getElementById("email-error");
const genderError = document.getElementById("gender-error");
const courseError = document.getElementById("course-error");
const yearError = document.getElementById("year-error");
const mobileError = document.getElementById("mobile-error");
const birthDateError = document.getElementById("birth-date-error");
const passwordError = document.getElementById("password-error");
const confirmPasswordError = document.getElementById("confirm-password-error");
const termsError = document.getElementById("terms-error");

const passwordStrength = document.getElementById("password-strength");

function showError(errorElement, message) {
    errorElement.textContent = message;
}

function clearError(errorElement) {
    errorElement.textContent = "";
}

function checkPasswordStrength() {
    const password = passwordInput.value;

    if (password.length === 0) {
        passwordStrength.textContent = "";
    } else if (password.length < 8) {
        passwordStrength.textContent = "Password strength: Weak";
    } else if (
        /[A-Z]/.test(password) &&
        /[a-z]/.test(password) &&
        /[0-9]/.test(password)
    ) {
        passwordStrength.textContent = "Password strength: Strong";
    } else {
        passwordStrength.textContent = "Password strength: Medium";
    }
}

passwordInput.addEventListener("input", checkPasswordStrength);

form.addEventListener("submit", function (event) {
    event.preventDefault();

    let isValid = true;

    // Clear old error messages
    clearError(nameError);
    clearError(idError);
    clearError(emailError);
    clearError(genderError);
    clearError(courseError);
    clearError(yearError);
    clearError(mobileError);
    clearError(birthDateError);
    clearError(passwordError);
    clearError(confirmPasswordError);
    clearError(termsError);

    // Name: only letters and spaces
    const namePattern = /^[A-Za-z ]+$/;

    if (nameInput.value.trim() === "") {
        showError(nameError, "Name is required.");
        isValid = false;
    } else if (!namePattern.test(nameInput.value.trim())) {
        showError(nameError, "Name should contain only letters.");
        isValid = false;
    }

    // Student ID: letters and numbers only
    const idPattern = /^[A-Za-z0-9]+$/;

    if (idInput.value.trim() === "") {
        showError(idError, "Student ID is required.");
        isValid = false;
    } else if (!idPattern.test(idInput.value.trim())) {
        showError(idError, "ID should contain only letters and numbers.");
        isValid = false;
    }

    // Email
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (emailInput.value.trim() === "") {
        showError(emailError, "Email is required.");
        isValid = false;
    } else if (!emailPattern.test(emailInput.value.trim())) {
        showError(emailError, "Enter a valid email address.");
        isValid = false;
    }

    // Gender
    const selectedGender = document.querySelector('input[name="gender"]:checked');

    if (!selectedGender) {
        showError(genderError, "Please select a gender.");
        isValid = false;
    }

    // Course
    if (courseInput.value === "") {
        showError(courseError, "Please select a course.");
        isValid = false;
    }

    // Year
    if (yearInput.value === "") {
        showError(yearError, "Please select a year.");
        isValid = false;
    }

    // Mobile: exactly 10 digits
    const mobilePattern = /^[0-9]{10}$/;

    if (!mobilePattern.test(mobileInput.value.trim())) {
        showError(mobileError, "Enter a valid 10-digit mobile number.");
        isValid = false;
    }

    // Birth date
    if (birthDateInput.value === "") {
        showError(birthDateError, "Please select your birth date.");
        isValid = false;
    }

    // Password: at least 8 characters, one uppercase, one lowercase, one number
    const passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$/;

    if (!passwordPattern.test(passwordInput.value)) {
        showError(
            passwordError,
            "Password needs 8 characters, one uppercase letter, one lowercase letter, and one number."
        );
        isValid = false;
    }

    // Confirm password
    if (confirmPasswordInput.value !== passwordInput.value) {
        showError(confirmPasswordError, "Passwords do not match.");
        isValid = false;
    }

    // Terms
    if (!termsInput.checked) {
        showError(termsError, "You must accept the terms and conditions.");
        isValid = false;
    }

    if (isValid) {
        alert("Registration successful!");
        form.reset();
        passwordStrength.textContent = "";
    }
});