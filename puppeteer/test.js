const puppeteer = require('puppeteer');

(async () => {
  const browser = await puppeteer.launch({
    headless: false,
    args: ['--headless', '--disable-gpu', '--remote-debugging-port=9222', '--no-sandbox', '--disable-setuid-sandbox'],
  });

  const page1 = await browser.newPage();
  try{
    await page1.goto('https://8081-fbebeaeacfadae308936297afaaccdone.premiumproject.examly.io/'); // Replace with the URL of your webpage.

    // Check for the existence of specific elements
    const hasCheckbox = await page1.$('input[type="checkbox"]');
  
    if (hasCheckbox) {
      console.log('TESTCASE:week2_day4_check_for_checkbox:success');
    } else {
      console.error('TESTCASE:week2_day4_check_for_checkbox:failure');
    }

  }catch(e){
    console.log(e);
  }

  const page2 = await browser.newPage();
  try{
    await page2.goto('https://8081-fbebeaeacfadae308936297afaaccdone.premiumproject.examly.io/'); // Replace with the URL of your webpage.

    // Check for the existence of specific elements
    const hasTextbox = await page1.$('input[type="text"]');
    if (hasTextbox) {
      console.log('TESTCASE:week2_day4_check_for_textbox:success');
    } else {
      console.error('TESTCASE:week2_day4_check_for_textbox:failure');
    }

  }catch(e){
    console.log(e);
  }

    const page3 = await browser.newPage();
  try{
    await page3.goto('https://8081-fbebeaeacfadae308936297afaaccdone.premiumproject.examly.io/'); // Replace with the URL of your webpage.

    // Check for the existence of specific elements
    const hasDropdown = await page3.$('select');  
    if (hasDropdown) {
      console.log('TESTCASE:week2_day4_check_for_Dropdown:success');
    } else {
      console.error('TESTCASE:week2_day4_check_for_Dropdown:failure');
    }
  }catch(e){
    console.log(e);
  }

  const page4 = await browser.newPage();
  try{
    await page4.goto('https://8081-fbebeaeacfadae308936297afaaccdone.premiumproject.examly.io/'); // Replace with the URL of your webpage.

    // Check for the existence of specific elements
    const hasSubmitButton = await page4.$('button[type="submit"]');
  
    if (hasSubmitButton) {
      console.log('TESTCASE:week2_day4_check_for_submitButton:success');
    } else {
      console.error('TESTCASE:week2_day4_check_for_submitButton:failure');
    }
    }catch(e){
        console.log(e);
    }

    const page5 = await browser.newPage();
    try{
        await page5.goto('https://8081-fbebeaeacfadae308936297afaaccdone.premiumproject.examly.io/'); // Replace with the URL of your webpage.

        // Fill out the form
        await page5.type('#hotelName', 'Sample Hotel');
        await page5.type('#location', 'Sample Location');
        await page5.select('#rating', '4'); // Assuming 4 Stars
        await page5.click('#pool'); // Check the Pool checkbox
        await page5.click('#gym'); // Check the Gym checkbox
        await page5.click('#spa'); // Check the Spa checkbox

        // Submit the form
        await page5.click('button[type="submit"]');

        // Wait for the table to update (you may need to adjust the timing)
        await page5.waitForSelector('#hotelList tr');

        // Get the text content of the first row in the table
        const firstRowText = await page5.evaluate(() => {
            const row = document.querySelector('#hotelList tr:first-child');
            return row.textContent;
        });

        // Check if the submitted data appears in the table
        if (firstRowText.includes('Sample Hotel') && firstRowText.includes('Sample Location')) {
            console.log('TESTCASE:week2_day4_check_for_functionality:success');
        } else {
            console.log('TESTCASE:week2_day4_check_for_functionality:failure');
        }
        }catch(e){
            console.log(e);
        }

    const page6 = await browser.newPage();
        try {
          await page6.goto('https://8081-fbebeaeacfadae308936297afaaccdone.premiumproject.examly.io/'); 
        
          await page6.setViewport({
            width: 1200,
            height: 1200,
          });
            const bodybackgroundStyling = await page6.$eval('body', (element) => {
            return getComputedStyle(element).getPropertyValue('background-color');
          });
          // console.log(bodybackgroundStyling)
          if (bodybackgroundStyling === "rgb(233, 216, 216)") {
            console.log('TESTCASE:week2_day4_section_background:success');
          } else {
            console.log('TESTCASE:week2_day4_section_background:failure');
          }
          }catch (e) {
            console.log('An error occurred:', e);
          }

      const page7 = await browser.newPage();
          try {
            await page7.goto('https://8081-fbebeaeacfadae308936297afaaccdone.premiumproject.examly.io/'); 
          
            await page7.setViewport({
              width: 1200,
              height: 1200,
            });
            const h1Styles = await page7.evaluate(() => {
              const h1Element = document.querySelector('h1');
              const computedStyles = window.getComputedStyle(h1Element);
        
              return {
                margin:computedStyles.getPropertyValue('margin-top'),
                align:computedStyles.getPropertyValue('text-align'),
                color:computedStyles.getPropertyValue('color')
              };
            });
            const expectedStyles ={
              margin: '20px',
              align: 'center',
              color: 'rgb(183, 110, 184)'
            };

            if (
              JSON.stringify(h1Styles) === JSON.stringify(expectedStyles)
            ) {
              console.log('TESTCASE:week2_day4_h1Style:success');
            } else {
              console.log('TESTCASE:week2_day4_h1Style:failure');
            }
        } catch (e) {
            console.log('Error:', e);
        }
        
        const page8 = await browser.newPage();
        try {
          await page8.goto('https://8081-fbebeaeacfadae308936297afaaccdone.premiumproject.examly.io/'); 
        
          await page8.setViewport({
            width: 1200,
            height: 1200,
          });
          const formStyles = await page8.evaluate(() => {
            const formElement = document.querySelector('form');
            const computedStyles = window.getComputedStyle(formElement);
      
            return {
              border:computedStyles.getPropertyValue('border'),
              backgroundColor:computedStyles.getPropertyValue('background-color'),
              borderRadius:computedStyles.getPropertyValue('border-radius')
            };
          });

          const expectedStyles ={
            border: '1px solid rgb(183, 110, 184)',
            backgroundColor: 'rgb(255, 255, 255)',
            borderRadius: '7px'
          };

          if (
            JSON.stringify(formStyles) === JSON.stringify(expectedStyles)
          ) {
            console.log('TESTCASE:week2_day4_formStyle:success');
          } else {
            console.log('TESTCASE:week2_day4_formStyle:failure');
          }
      } catch (e) {
          console.log('Error:', e);
      }

      
      const page9 = await browser.newPage();
      try {
        await page9.goto('https://8081-fbebeaeacfadae308936297afaaccdone.premiumproject.examly.io/'); 
      
        await page9.setViewport({
          width: 1200,
          height: 1200,
        });
        const labelStyles = await page9.evaluate(() => {
          const labelElement = document.querySelector('label');
          const computedStyles = window.getComputedStyle(labelElement);
    
          return {
            fontWeight:computedStyles.getPropertyValue('font-weight'),
            color:computedStyles.getPropertyValue('color')
          };
        });

        // console.log(labelStyles);
        const expectedStyles ={
          fontWeight: '700',
          color: 'rgb(183, 110, 184)'
        };

        if (
          JSON.stringify(labelStyles) === JSON.stringify(expectedStyles)
        ) {
          console.log('TESTCASE:week2_day4_labelStyle:success');
        } else {
          console.log('TESTCASE:week2_day4_labelStyle:failure');
        }
    } catch (e) {
        console.log('Error:', e);
    }

    const page10 = await browser.newPage();
      try {
        await page10.goto('https://8081-fbebeaeacfadae308936297afaaccdone.premiumproject.examly.io/'); 
      
        await page10.setViewport({
          width: 1200,
          height: 1200,
        });
        const buttonStyles = await page10.evaluate(() => {
          const labelElement = document.querySelector('button');
          const computedStyles = window.getComputedStyle(labelElement);
    
          return {
            backgroundColor:computedStyles.getPropertyValue('background-color'),
            color:computedStyles.getPropertyValue('color'),
            cursor:computedStyles.getPropertyValue('cursor')
          };
        });

        // console.log(buttonStyles);
        const expectedStyles ={
          backgroundColor: 'rgb(183, 110, 184)',
          color: 'rgb(255, 255, 255)',
          cursor:'pointer'
        };

        if (
          JSON.stringify(buttonStyles) === JSON.stringify(expectedStyles)
        ) {
          console.log('TESTCASE:week2_day4_buttonStyle:success');
        } else {
          console.log('TESTCASE:week2_day4_buttonStyle:failure');
        }
    } catch (e) {
        console.log('Error:', e);
    }


    const page11 = await browser.newPage();
      try {
        await page11.goto('https://8081-fbebeaeacfadae308936297afaaccdone.premiumproject.examly.io/'); 
      
        await page11.setViewport({
          width: 1200,
          height: 1200,
        });
        const tableStyles = await page11.evaluate(() => {
          const labelElement = document.querySelector('table');
          const computedStyles = window.getComputedStyle(labelElement);
    
          return {
            borderCollapse:computedStyles.getPropertyValue('border-collapse'),
            width:computedStyles.getPropertyValue('width'),
            backgroundColor:computedStyles.getPropertyValue('background-color'),
            color:computedStyles.getPropertyValue('color'),
            border:computedStyles.getPropertyValue('border')

          };
        });

        // console.log(tableStyles);
        const expectedStyles ={
          borderCollapse: 'collapse',
          width: '960px',
          backgroundColor: 'rgb(255, 255, 255)',
          color: 'rgb(92, 24, 111)',
          border: '2px solid rgb(183, 110, 184)',
        };

        if (
          JSON.stringify(tableStyles) === JSON.stringify(expectedStyles)
        ) {
          console.log('TESTCASE:week2_day4_tableStyle:success');
        } else {
          console.log('TESTCASE:week2_day4_tableStyle:failure');
        }
    } catch (e) {
        console.log('Error:', e);
    }


  finally{
    await page1.close();
    await page2.close();
    await page3.close();
    await page4.close();
    await page5.close();
    await page6.close();
    await page7.close();
    await page8.close();
    await page9.close();
    await page10.close();
    await page11.close();
  }
 

  await browser.close();
})();
