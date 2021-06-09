import { SearchPage } from './search.po';

import { browser,by,protractor,element } from "protractor";

describe('Search Page', () => {
    let page: SearchPage;
    beforeEach(() => {
      page = new SearchPage();
      browser.driver.manage().window().maximize();
    });

   
    it ('Create a new PlayList -Test 01', ()=>{
       browser.sleep(2000);
      element(by.id("searchMuzix")).clear();
      page.setSearchElement("zoombi");
      browser.actions().sendKeys(protractor.Key.ENTER).perform();
      browser.sleep(3000);
      page.createNewPlaylist();
      const EC = protractor.ExpectedConditions;   
       const snackBar = element(by.xpath('/html/body/div[2]'));
       browser.wait(EC.visibilityOf(snackBar), 5000);
       element(by.xpath('/html/body/div[2]')).getText().then(function (val) {
          console.log("--------"+val) ;
          expect(val).toEqual('playlist Muzix updated');
       })
    });


       
    it('Add to playlist -Test02', async()=>   {
      element(by.id("searchMuzix")).clear();
      page.setSearchElement("bts");
      browser.actions().sendKeys(protractor.Key.ENTER).perform();
      browser.sleep(2000);
      page.addplaylist();
      const EC1 = protractor.ExpectedConditions;   
      const snackBar1 = element(by.xpath('/html/body/div[2]'));
      
      browser.wait(EC1.visibilityOf(snackBar1), 5000);
      element(by.xpath('/html/body/div[2]')).getText().then(function (val1) {
        console.log(val1)  
        expect(val1).toEqual('Muzix added to playlist')
      
       });
    });

    it('Add to BookMark -New Music Test03', async() => {
      element(by.id("searchMuzix")).clear();
         page.setSearchElement("selena gomez");
         browser.actions().sendKeys(protractor.Key.ENTER).perform();
         browser.sleep(3000);
         page.clickOnBookmark();
         const EC = protractor.ExpectedConditions;   
         const snackBar = element(by.xpath('/html/body/div[2]'));
         browser.wait(EC.visibilityOf(snackBar), 5000);
         element(by.xpath('/html/body/div[2]')).getText().then(function (val) {
            console.log("--------"+val) ;
           expect(val).toEqual('Muzix added to Bookmark');
          });
    });    

      it('Add to BookMark -Same Music Test04', async() => {

         element(by.id("searchMuzix")).clear();
         page.setSearchElement("selena gomez");
          browser.actions().sendKeys(protractor.Key.ENTER).perform();
         browser.sleep(3000);
         page.clickOnBookmark();
         const EC = protractor.ExpectedConditions;   
         const snackBar = element(by.xpath('/html/body/div[2]'));
         browser.wait(EC.visibilityOf(snackBar), 5000);
         element(by.xpath('/html/body/div[2]')).getText().then(function (val) {
             console.log("--------"+val) ;
            expect(val).toEqual('Http failure response for http://localhost:8082/api/v1/muzixService/createbookmark: 400 OK');
         });
        
      });    


}) 




