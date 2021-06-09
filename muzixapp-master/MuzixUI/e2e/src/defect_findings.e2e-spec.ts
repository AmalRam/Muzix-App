import { SearchPage } from './search.po';

import { browser,by,protractor,element } from "protractor";

describe('Defect Page', () => {
    let page: SearchPage;
    beforeEach(() => {
      page = new SearchPage();
      page.navigateTo();
      browser.driver.manage().window().maximize();
    });



it ('Create a same PlayList -Test 01', ()=>{
  
      element(by.id("searchMuzix")).clear();
      page.setSearchElement("zoombi");
      browser.actions().sendKeys(protractor.Key.ENTER).perform();
      browser.sleep(3000);
      page.createNewPlaylist();

     browser.get("http://localhost:4200/muzix/playlist");
     browser.sleep(3000);
     expect().nothing();
  });

         
    it('Add to same music into the same playlist-Test02', async()=>   {
     
      element(by.id("searchMuzix")).clear();
      page.setSearchElement("bts");
      browser.actions().sendKeys(protractor.Key.ENTER).perform();
      browser.sleep(2000);
     
    element(by.xpath('/html/body/app-root/muzix-muzix-search/muzix-container/div/div/muzix-thumbnail[1]/div/div/a[2]')).click();
    browser.sleep(2000);
    element(by.xpath('/html/body/div[2]/div[2]/div/mat-dialog-container/muzix-movie-dialog/div/mat-form-field[1]/div/div[1]/div/mat-select/div/div[1]/span')).click();
    browser.sleep(2000);
    element(by.xpath('/html/body/div[2]/div[4]/div/div/div/mat-option[1]')).click();
    browser.sleep(2000);
    element(by.id('btn-add-to-exisiting-playlist')).click();
    browser.sleep(2000);
     
      browser.sleep(2000);
       browser.get("http://localhost:4200/muzix/playlist");
       browser.sleep(4000);
       expect().nothing();
    });

});