function validateEmail() {
    var email = document.getElementById("user-email").value;
    var pattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    if (!pattern.test(email) || email === 0) {
        document.getElementById("errorMessage").style.display = "block";
        document.getElementById("user-email-password").disabled = true;
        document.getElementById("user-email-passwords").disabled = true;
        document.getElementById("user-address").disabled = true;
        document.getElementById("user-phone-num").disabled = true;
        document.getElementById("user-email").classList.add("invalid");
        document.getElementById("button").style.display = "none";
    } else {
        document.getElementById("errorMessage").style.display = "none";
        document.getElementById("user-email-password").disabled = false;
        document.getElementById("user-email-passwords").disabled = false;
        document.getElementById("user-address").disabled = false;
        document.getElementById("user-phone-num").disabled = false;
        document.getElementById("user-email").classList.remove("invalid");
        document.getElementById("button").style.display = "block";
    }
}

function validatePassword() {
    var password = document.getElementById("user-email-password").value;
    var passwords = document.getElementById("user-email-passwords").value;
    var pattern = /^(?=.*\d)[a-zA-Z\d]{9,30}$/;
     if (!pattern.test(password)) {
        document.getElementById("errorMessage3").style.display = "block";
        document.getElementById("user-email-password").classList.add("invalid");
        document.getElementById("user-address").disabled = true;
        document.getElementById("user-phone-num").disabled = true;
        document.getElementById("button").style.display = "none";
        
    }else if (password !== passwords) {
        document.getElementById("errorMessage2").style.display = "block";
        document.getElementById("user-address").disabled = true;
        document.getElementById("user-phone-num").disabled = true;
        document.getElementById("user-email-password").classList.add("invalid");
        document.getElementById("user-email-passwords").classList.add("invalid");
        document.getElementById("errorMessage3").style.display = "none";
        document.getElementById("button").style.display = "none";
    }else {
        document.getElementById("errorMessage3").style.display = "none";
        document.getElementById("errorMessage2").style.display = "none";
        document.getElementById("user-address").disabled = false;
        document.getElementById("user-phone-num").disabled = false;
        document.getElementById("user-email-passwords").classList.remove("invalid");
        document.getElementById("user-email-password").classList.remove("invalid");
        document.getElementById("button").style.display = "block";
    }

}

function checkPhone() {
    var phone = document.getElementById("user-phone-num").value;
    if (!phone.match(/^[0-9]{10}$/)) {
        document.getElementById("errorMessage4").style.display = "block";
        document.getElementById("button").style.display = "none";
    } else {
        document.getElementById("errorMessage4").style.display = "none";
        document.getElementById("button").style.display = "block";
    }
}

function validateForm(event) {
    if (!validatePassword()) {
        event.preventDefault();
        return false;
    }
    if (!validateEmail()) {
        event.preventDefault();
        return false;
    }

    if (!checkPhone()) {
        event.preventDefault();
        return false;
    }
    return true;
    
    
}