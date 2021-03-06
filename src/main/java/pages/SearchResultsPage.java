package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helpers.SearchWith;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage extends HomePage{
    public static final String PAGE = "SearchResultsPage";
    protected WebDriverWait wait;

    @SearchWith(inPage = SearchResultsPage.PAGE, locatorsFile = "src/main/resources/ObjectRepository.json", name = "easy")
    private WebElement easy ;

    @SearchWith(inPage = SearchResultsPage.PAGE, locatorsFile = "src/main/resources/ObjectRepository.json", name = "intermediate")
    private WebElement intermediate ;

    @SearchWith(inPage = SearchResultsPage.PAGE, locatorsFile = "src/main/resources/ObjectRepository.json", name = "difficult")
    private WebElement difficult ;

    @SearchWith(inPage = SearchResultsPage.PAGE, locatorsFile = "src/main/resources/ObjectRepository.json", name = "milesDropDown")
    private WebElement milesDropDown ;

    @SearchWith(inPage = SearchResultsPage.PAGE, locatorsFile = "src/main/resources/ObjectRepository.json", name = "milesThree")
    private WebElement milesThree ;

    @SearchWith(inPage = SearchResultsPage.PAGE, locatorsFile = "src/main/resources/ObjectRepository.json", name = "milesFive")
    private WebElement milesFive ;

    @SearchWith(inPage = SearchResultsPage.PAGE, locatorsFile = "src/main/resources/ObjectRepository.json", name = "milesTen")
    private WebElement milesTen ;

    @SearchWith(inPage = SearchResultsPage.PAGE, locatorsFile = "src/main/resources/ObjectRepository.json", name = "milesTwenty")
    private WebElement milesTwenty ;

    @SearchWith(inPage = SearchResultsPage.PAGE, locatorsFile = "src/main/resources/ObjectRepository.json", name = "searchResults")
    private WebElement searchResults ;
    
    @SearchWith(inPage = SearchResultsPage.PAGE, locatorsFile = "src/main/resources/ObjectRepository.json", name = "myTourName")
    private WebElement myTourName ;
    
    @SearchWith(inPage = SearchResultsPage.PAGE, locatorsFile = "src/main/resources/ObjectRepository.json", name = "saveMyTour")
    private WebElement saveMyTour ;
    
    public SearchResultsPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 10);
    }

    public void selectDifficulty(String difficulty) {
        if (difficulty.equalsIgnoreCase("easy")) {
            easy.click();
        } else if (difficulty.equalsIgnoreCase("intermediate")) {
            intermediate.click();
        } else if (difficulty.equalsIgnoreCase("difficult")) {
            difficult.click();
        }
    }

    public void selectMiles(int miles) {
        milesDropDown.click();
        switch (miles) {
            case 3:
                milesThree.click();
                break;
            case 5:
                milesFive.click();
                break;
            case 10:
                milesTen.click();
                break;
            case 20:
                milesTwenty.click();
                break;
        }

    }

    public int numOfFilteredResults() {
        return Integer.parseInt(searchResults.getText());
    }
    
    public void saveMyTour() {
    	saveMyTour.click();
    	driver.findElement(By.xpath("//div[contains(@class,'tw-p-3 tw-text-right')]/button")).click();
    	WebElement saveTour = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
    	saveTour.click();
    	
    }
    
    public String tourNameSelected() {
    	return myTourName.getText();
    	
    }
}

