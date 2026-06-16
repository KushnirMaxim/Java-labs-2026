import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizedApp {
    public static void main(String[] args) {
        // Тест різних локалей
        String[] languages = {"uk", "et", "fr", "de", "he"};
        String[] countries = {"UA", "EE", "FR", "DE", "IL"};

        for (int i = 0; i < languages.length; i++) {
            Locale locale = new Locale(languages[i], countries[i]);
            ResourceBundle bundle = ResourceBundle.getBundle("i18n/Bundle", locale);
            System.out.println("\n--- Локаль: " + locale + " ---");
            System.out.println(bundle.getString("greeting"));
            System.out.println(bundle.getString("app_name"));
            System.out.println(bundle.getString("habitat"));
            System.out.println(bundle.getString("species"));
            System.out.println(bundle.getString("pond"));
        }
    }
}