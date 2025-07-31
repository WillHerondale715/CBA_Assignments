document.querySelector("#registrationForm").addEventListener("submit", (event) => {
  event.preventDefault();

  const fullName = document.querySelector("#fullname").value.trim();
  const user = document.querySelector("#username").value.trim();
  const mail = document.querySelector("#email").value.trim();
  const phoneNo = document.querySelector("#phone").value.trim();
  const selectedGender = document.querySelector("#gender").value;
  const pwd = document.querySelector("#password").value;
  const confirmPwd = document.querySelector("#confirmPassword").value;
  const feedback = document.querySelector("#message");

  feedback.textContent = "";
  feedback.classList.remove("text-green-500");
  feedback.classList.add("text-red-500");

  if (fullName.length < 3) {
    feedback.textContent = "Name should have at least 3 characters.";
    return;
  }

  if (user.length < 4) {
    feedback.textContent = "Username must be a minimum of 4 characters.";
    return;
  }

  const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!emailPattern.test(mail)) {
    feedback.textContent = "Invalid email format.";
    return;
  }

  if (!/^\d{10}$/.test(phoneNo)) {
    feedback.textContent = "Phone must be exactly 10 digits.";
    return;
  }

  if (!selectedGender) {
    feedback.textContent = "Select a gender before continuing.";
    return;
  }

  if (pwd.length < 6) {
    feedback.textContent = "Password should be at least 6 characters long.";
    return;
  }

  if (pwd !== confirmPwd) {
    feedback.textContent = "Passwords entered do not match.";
    return;
  }

  // All validations passed
  feedback.textContent = "Registration complete!";
  feedback.classList.remove("text-red-500");
  feedback.classList.add("text-green-500");

  // Optional: Reset the form or send data to server
  // event.target.reset();
});
