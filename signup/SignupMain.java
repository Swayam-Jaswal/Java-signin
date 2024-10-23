package signup;

import java.util.Scanner;

interface SignIn{
	void Name();
	void Password();
	void Gmail();
}

class User implements SignIn {
	Scanner sc = new Scanner(System.in);
	private String name;
	private String pass;
	private String mail;
	private int check = 0;
	public static final String greenColor = "\u001B[32m";
	public static final String redColor = "\u001B[31m";
	public static final String yellowColor = "\u001B[33m";
	public static final String removeColor = "\u001B[0m";
	
	public void Name(){
		
		int isValid = 0;
		
		while(isValid == 0) {
			System.out.print(yellowColor+"Enter Your FullName:"+removeColor);
			name = sc.nextLine();
			if(name.matches("[A-Z][a-zA-Z]+ +[A-Z][a-zA-Z]+")) {
				System.out.println(greenColor+"valid Name"+removeColor);
				check++;
				isValid = 1;
			}else {
				System.out.println(redColor+"Name is not Valid. Please try again"+removeColor);
			}
		}
	}
	
	public void Password() {
		int isValid = 0;
		
		while(isValid == 0) {
			System.out.print(yellowColor+"Enter Password: "+removeColor);
			pass = sc.nextLine();
			if(pass.length()<15) {
				if(!(pass.length()>5)) {
					System.out.println(redColor+"Password is too short. Try again....."+removeColor);
				}else {
					if(!pass.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
						System.out.println(redColor+"Password must contain special character"+removeColor);
					}else {
						if(!pass.matches("^[A-Z].*")) {
							System.out.println(redColor+"First letter should be in capital"+removeColor);
						}else {
							if(pass.matches("[A-Z].*[!@#$%^&*(),.?\":{}|<>].*[0-9]")) {
								System.out.println(greenColor+"valid password"+removeColor);
								check++;
								isValid = 1;
							}else {
								System.out.println(redColor+"Invalid Password. Try again....."+removeColor);
							}
						}
					}
				}
			}else {
				System.out.println(redColor+"Password is too long"+removeColor);
			}
		}
	}
	
	public void Gmail() {
		int isValid = 0;
		
		while(isValid == 0) {
			System.out.print(yellowColor+"Enter Gmail:"+removeColor);
			mail = sc.nextLine();
			if(mail.matches("[a-zA-Z0-9._%+-]+@gmail.com")) {
				System.out.println(greenColor+"valid Gmail"+removeColor);
				check++;
				isValid = 1;
			}else {
				System.out.println(redColor+"Enter valid gmail ID"+removeColor);
			}
		}
	}
	
	public void finalCheck() {
		if(check == 3) {
			System.out.println(greenColor+"Successful"+removeColor);
		}
	}
	
	public String getName() {
		return name;
	}
	
	public String getGmail() {
		return mail;
	}
}

public class SignupMain {
	public static void main(String[] args) {
		User u1 = new User();
		u1.Name();
		u1.Password();
		u1.Gmail();

		String u1Name = u1.getName();
		String u1Gmail = u1.getGmail();
		
		System.out.println("User Name : " + u1Name);
		System.out.println("User Gmail : " + u1Gmail);
		
		u1.finalCheck();
	}
}