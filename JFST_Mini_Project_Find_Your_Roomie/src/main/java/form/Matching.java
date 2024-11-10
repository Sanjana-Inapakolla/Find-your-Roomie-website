package form;

import authentication.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Matching {
	
	/*public static void main(String args[]) {
		getMatches();
	}*/

    public List<Pair>  getMatches(User curUser
    		){
        DBConnect db = new DBConnect();
        List<User> list = DBConnect.getAllUsers(curUser.getEmail());
       // List<User> list = db.getAllUsers("khloe");
        System.out.print(list.get(0).getName());
        List<Pair> matches = new ArrayList<>();
        System.out.print(list.size()>0);
       if(list.size() > 0) {
            for(User u : list) {
                int s = calculateScore(curUser, u);
                matches.add(new Pair(u, s));
            }
            // Sort the matches based on score in descending order
            Collections.sort(matches, (o1, o2) -> o2.getScore() - o1.getScore());
        }
       System.out.print(matches.size()>0);
        return matches; // return empty list if no matches */
    }

    public int calculateScore(User currentUser, User user) {
        int score = 0;

        // Matching city
        if(currentUser.getCity().equalsIgnoreCase(user.getCity())) {
            score += 15;
        }

        // Matching area
        if(currentUser.getArea().equalsIgnoreCase(user.getArea())) {
            score += 20;
        }

        // Matching gender
        if(currentUser.getGender().equalsIgnoreCase(user.getGender())) {
            score += 10;
        }

        // Matching smoking habits
        if(currentUser.getSmoke().equalsIgnoreCase(user.getSmoke())) {
            score += 10;
        }

        // Matching diet
        if(currentUser.getDiet().equalsIgnoreCase(user.getDiet())) {
            score += 10;
        }

        // Matching drinking habits
        if(currentUser.getDrink().equalsIgnoreCase(user.getDrink())) {
            score += 10;
        }

        // Age score (you may want to cap it or apply a more complex calculation)
        int ageDifference = Math.abs(currentUser.getAge() - user.getAge());
        score += Math.max(0, 10 - ageDifference); // Ensure no negative score

        return score;
    }
}


