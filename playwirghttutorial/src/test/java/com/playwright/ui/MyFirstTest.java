package com.playwright.ui;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class MyFirstTest {
    public static void main(String[] args) {
        try {
            Playwright playwright = Playwright.create();
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
//            context.tracing().start(new Tracing.StartOptions()
//                    .setScreenshots(true)
//                    .setSnapshots(true)
//                    .setSources(true));

            Page page = context.newPage();
            page.navigate("https://www.equator.com/");
            page.locator("").click();;
            page.locator("").fill("Atlanta, GA");
            page.getByPlaceholder("Search by city, neighborhood, ZIP, address, MLS#").click();
            page.getByPlaceholder("Search by city, neighborhood, ZIP, address, MLS#").fill("Atlanta, GA");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search")).click();
            page.locator("#cdk-overlay-1 img").nth(1).click();
            page.locator(".dropdown-label").first().click();
            page.getByRole(AriaRole.LISTITEM).filter().locator("span").nth(1).click();
            page.locator("eq-saletype-filter div").filter().locator("div").nth(2).click();
            page.locator("span").filter().click();
            page.locator(".card__image__favIcon > .ng-star-inserted").first().click();
            page.close();

//            context.tracing().stop(new Tracing.StopOptions()
//                    .setPath(Paths.get("trace.zip")));

        }
        catch(Exception e){

        }
    }

}
