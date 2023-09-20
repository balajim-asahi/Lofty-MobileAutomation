package mobileautomation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;




public class Signup extends BaseClass{

	static WebElement signup,inputPhonenumber,nexbtn,OTP,EnterOTP,welcomepage,firstName,lastName,emailid,socialmedia,Username,Reffered,question1,answer1;

	static String phonenumber = "3000000000";
    static String FirstName = "Michale";
    static String LasttName = "Donald";
    static String EmailId = "michaledonal@gmail.com";

    static String userName = "Michale003";

    static String RefferedBy = "Dorris";

    static String answerFor1 = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
            "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
            "when an unknown printer took a galley of type and scrambled it to make a type specimen book. ";
	@Test(priority = 0)
	public void UsingPhoneNumber() throws InterruptedException {

        Actions actions = new Actions(driver);

        Thread.sleep(10000);
        signup = driver.findElement(By.xpath("//*[@text='Sign up with phone number']"));
        signup.click();
        inputPhonenumber = driver.findElement(By.className("android.widget.EditText"));
        inputPhonenumber.sendKeys(phonenumber);
        Thread.sleep(2000);
        nexbtn = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]"));
        nexbtn.click();
        Thread.sleep(5000);

        OTP = driver.findElement(By.xpath("(//*[@class='android.widget.TextView'])[3]"));

        boolean checkOTP = OTP.isDisplayed();

        String OTPgenerated = null;
        if (checkOTP) {
            OTPgenerated = OTP.getText();
            System.out.println(OTPgenerated);
        } else {
            System.out.println("Failed to generate OTP");
        }

        String[] OTPArray = OTPgenerated.split(" ");
        for (String s : OTPArray) {

            System.out.println(s + ", ");
        }

        EnterOTP = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]"));
        String pastOTP = OTP.getText();
        EnterOTP.click();
        actions.sendKeys(OTPArray[0]).perform();

        System.out.println("OTP verified and moved to onboarding");


        //Welcome page validation
        Thread.sleep(1000);
        welcomepage = driver.findElement(By.xpath("//*[@text='Welcome!']"));
       boolean check = welcomepage.isDisplayed();
       if (check){
           System.out.println("Moved to welcome screen");
       }else {
           System.out.println("Failed to move welcome screen");
       }
    }
    @Test(priority = 1)
    public void welcome() throws InterruptedException {
        Thread.sleep(1000);
        firstName = driver. findElement(By.xpath("//*[@text='First name *']"));
        firstName.clear();
        firstName.click();
        firstName.sendKeys(FirstName);

        lastName = driver.findElement(By.xpath("//*[@text='Last name *']"));
        lastName.clear();
        lastName.click();
        lastName.sendKeys(LasttName);

        emailid = driver.findElement(By.xpath("//*[@text='Email address *']"));
        emailid.clear();
        emailid.click();
        emailid.sendKeys(EmailId);
        Keyboardminimize.minimze();


        ScrollHelper.ScrollDown("Username/URL *");


        Thread.sleep(1000);
        socialmedia = driver.findElement(By.xpath("//*[@text='Instagram']"));
        socialmedia.click();
        socialmedia.click();

        Username = driver.findElement(By.xpath("//*[@text='Username/URL *']"));
        Username.clear();
        Username.click();
        Username.sendKeys(userName);

          Keyboardminimize.minimze();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ImageView")).click();

    }
    @Test(priority = 2)
    public static void refferedBy(){
      Reffered = driver.findElement(By.xpath("//*[@text='Name (optional)']"));
      Reffered.clear();
    Reffered.sendKeys(RefferedBy);
    driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ImageView")).click();

    }
    @Test(priority = 3)
    public static void answerprompt() throws InterruptedException {
        question1 = driver.findElement(By.xpath("//*[@text='What's your dream career or job?']"));
        question1.click();
        Thread.sleep(1000);
        answer1 = driver.findElement(By.className("android.widget.EditText"));
        answer1.sendKeys(answerFor1);
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ImageView")).click();
    }
}
