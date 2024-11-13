package chat;

public class Pair_messages {
 String username;
 String message;

public Pair_messages(String username, String message){
	this.setUsername(username);
	this.setMessage(message);
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}


}
