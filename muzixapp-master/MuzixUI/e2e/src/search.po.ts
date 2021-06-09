import {browser,element,by,protractor} from 'protractor';
export class SearchPage { 

    public baseUrl ='http://localhost:4200/muzix/search';
    navigateTo(): any
  {
    browser.ignoreSynchronization= true;
   // browser.waitForAngularEnabled;
    return browser.get(this.baseUrl);
  }

  setSearchElement(word: string): any{
    
    browser.sleep(3000);
    element(by.id("searchMuzix")).sendKeys(word);
  }


  clickOnBookmark(): any{
    // element.all(by.xpath('/html/body/app-root/muzix-muzix-search/muzix-container/div/div/muzix-thumbnail[1]/div/div/a[1]')).click();
    element(by.xpath("/html/body/app-root/muzix-muzix-search/muzix-container/div/div/muzix-thumbnail[1]/div/div/a[1]")).click();
  }

  addplaylist():any{
    browser.sleep(2000);
    element(by.xpath('/html/body/app-root/muzix-muzix-search/muzix-container/div/div/muzix-thumbnail[1]/div/div/a[2]')).click();
    element(by.xpath('/html/body/div[2]/div[2]/div/mat-dialog-container/muzix-movie-dialog/div/mat-form-field[1]/div/div[1]/div/mat-select/div/div[1]/span')).click();
    element(by.xpath('/html/body/div[2]/div[4]/div/div/div/mat-option[1]')).click();
    element(by.id('btn-add-to-exisiting-playlist')).click();
    browser.sleep(2000);
 
   }

   createNewPlaylist() :any {
    browser.sleep(2000);
    element(by.xpath('/html/body/app-root/muzix-muzix-search/muzix-container/div/div/muzix-thumbnail[1]/div/div/a[2]')).click();
    element(by.xpath('//*[@id="text-new-playlist"]')).sendKeys("playList04");
    element(by.id('btn-create-new-playlist')).click();
   }

}
