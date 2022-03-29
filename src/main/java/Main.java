import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        System.out.println(minimumChangeRequired(s));

    }

    public static Integer minimumChangeRequired(String pass) {
        Integer changes = 0;
        Integer count = howManyAreMissing(pass);

        if (pass.length() < 6) {
            if (pass.length() < 3) {
                changes = changes + (6 - pass.length());
            } else if (!isLowerCaseCharacter(pass) && !isUpperCaseCharacter(pass) && !isNumeric(pass)) {
                changes = 3;
            } else if ((!isLowerCaseCharacter(pass) && !isUpperCaseCharacter(pass)) || (!isLowerCaseCharacter(pass) && !isNumeric(pass)) || (!isUpperCaseCharacter(pass) && !isNumeric(pass))) {
                changes = 2;
            } else if (!isNumeric(pass) || !isLowerCaseCharacter(pass) || !isUpperCaseCharacter(pass)) {
                if(pass.length()==5) {
                    changes = 1;
                }else changes=2;
            }

        }

        if (pass.length() >= 6 && pass.length() <= 20) {

            if (charactersInARow(pass) <= count) {
                changes = count;
            } else if (charactersInARow(pass) > count) {
                changes = charactersInARow(pass);
            }
        }

        if(pass.length()>20){
            if(charactersInARow(pass)<=count){
                changes=changes+count+(pass.length()-20);
            } else if(charactersInARow(pass)>count && (pass.length()-20) > charactersInARow(pass) ){
                changes=changes+(pass.length()-20) + count;
            } else if(charactersInARow(pass)>count && (pass.length()-20) < charactersInARow(pass) ){
                changes=changes+charactersInARow(pass);
            }


        }


        return changes;
    }

    public static boolean isLowerCaseCharacter(String pass) {
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isLowerCase(pass.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isUpperCaseCharacter(String pass) {
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isUpperCase(pass.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNumeric(String pass) {
        for (int i = 0; i < pass.length(); i++) {
            if (pass.charAt(i) >= '0' && pass.charAt(i) <= '9') {
                return true;
            }
        }
        return false;
    }

    public static Integer charactersInARow(String pass) {
        Integer count = 0;
        for (int i = 0; i < pass.length() - 2; i++) {
            if (pass.charAt(i) == pass.charAt(i + 1) && pass.charAt(i + 1) == pass.charAt(i + 2)) {
                count++;
                i = i + 2;
            }
        }


        return count;

    }

    public static Integer howManyAreMissing(String pass){
        Integer count = 0;

        if (!isLowerCaseCharacter(pass)) {
            count++;
        }
        if (!isUpperCaseCharacter(pass)) {
            count++;
        }
        if (!isNumeric(pass)) {
            count++;
        }
        return count;
    }

}
