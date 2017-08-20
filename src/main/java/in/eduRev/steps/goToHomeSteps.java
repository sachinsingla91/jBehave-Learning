package in.eduRev.steps;

import in.eduRev.pages.*;

import org.hamcrest.Matchers;
import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * <p>
 * A simple POJO, which will contain the Java methods that are mapped to the textual steps
 * The methods need to annotated with one of the JBehave annotations and the annotated value
 * should contain a regex pattern that matches the textual step</p>
 */
public class goToHomeSteps extends Steps{

   /*
    public Steps(PageFactory pageFactory){
        home = pageFactory.newHome();
        maps = pageFactory.newMaps();
        reviews = pageFactory.newReviews();
        searchResults = pageFactory.newSearchResults();
        videos = pageFactory.newVideos();
    }
*/
    @Given("I am on Yell.com")
    public void homepageOnYellDotCom() {
        home.go();
    }

    @When("I search for a <profession> in <location>")
    public void specifySearchLocation(@Named("profession") String profession, @Named("location") String location) {
        home.searchForWhatWhere(profession, location);
    }


    @Then("there are search results")
    @Alias("results will be displayed in the list view")
    public void thereAreSearchResults() {
        assertThat(searchResults.resultsFound(), Matchers.greaterThan(0));
    }


    @When("I want to browse the reviews")
    public void goToReviews() {
        home.goToReviewsSection();
    }

    @Given("I want to browse through featured reviews")
    @Composite(steps = {"Given I am on Yell.com",
            "When I want to browse the reviews"})
    public void browseToTheFeaturedReviewsPage() {
    	homepageOnYellDotCom();
    	goToReviews();
    }

    @When("I want to browse the videos")
    public void goToVideos() {
        home.goToVideosSection();
    }

    @Given("I want to browse through featured videos")
    @Composite(steps = {"Given I am on Yell.com",
                        "When I want to browse the videos"})
    public void browseToTheFeaturedVideosPage() {
        // this is a composite step, so nothing should be added here
    	homepageOnYellDotCom();
    	goToVideos();
    	
    }

    @Then("I should see a list of featured short videos")
    public void thereAreVideosListed(){
        assertThat(videos.getNumberOfFeaturedVideos(), Matchers.greaterThan(0));
    }
}
