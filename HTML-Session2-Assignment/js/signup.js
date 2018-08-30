function validateFirstName(){
	     var pattern = new RegExp("(^[A-Za-z]+$)");  
		 var firstname = document.getElementById('t_name');
        if(firstname.value.length > 2 && pattern.test(firstname.value)){
		firstname.style.borderColor = "green";
		return true;
		}else{
		firstname.style.borderColor = "red";	
		}
}

function validateLastName(){
	     var pattern = new RegExp("(^[A-Za-z]+$)");  
		 var lastname = document.getElementById('t_lastname');
        if(lastname.value.length > 2 && pattern.test(lastname.value)){
		lastname.style.borderColor = "green";		
		return true;
		}else{
		lastname.style.borderColor = "red";	
		}
}

function validatePassword(){
      var pattern = new RegExp("^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{8,}$");
      var password = document.getElementById("t_password");
      if(pattern.test(password.value)){
      password.style.borderColor = "green";
	  return true;
      }
      else{
       password.style.borderColor = "red";
      }
}

function validateContact(){
	 var pattern = new RegExp("(^[0-9]+$)");
	 var contact = document.getElementById("t_contact");
	 if(pattern.test(contact.value) && contact.value.length == 10){
	  contact.style.borderColor = "green";
	  return true;
	 }else{
	  contact.style.borderColor = "red";	 
	 }
	 	   
}

function validateEmail(){
	var pattern = new RegExp("^[A-Za-z]+[.A-Za-z0-9]+@+[A-Za-z0-9]+(.[a-zA-Z]{2,4})+$");
	var email = document.getElementById("t_email");
	if(pattern.test(email.value)){
		email.style.borderColor = "green";
		return true;
	}else{
	  email.style.borderColor = "red";	
	}
}

function checkEquality(){
	var password = document.getElementById("t_password");
	var confirmpassword = document.getElementById("t_confirmpassword");
	
	if(password.value == confirmpassword.value){
	 	confirmpassword.style.borderColor = "green";
		return true;
	}else{
		confirmpassword.style.borderColor = "red"; 
	}
}

function validateAll(){
        if(validateFirstName() && validateLastName() && validatePassword() && validateContact() && validateEmail() && checkEquality()){
		 return true;
		}else{
		 return false;	
		}		
}


function signup(){
   debugger;
   if(validateAll()){
	
   alert('Success');
   document.signupform.action = 'home.html';
   document.signupform.submit();
   }else{
   alert('Invalid Input ! All Fields are Mandatory ! Input Correctly');
   }
}