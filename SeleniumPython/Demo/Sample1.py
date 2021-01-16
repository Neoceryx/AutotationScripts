import time  
import sys
from selenium import webdriver  
from selenium.webdriver.common.keys import Keys  
from webdriver_manager.chrome import ChromeDriverManager
from termcolor import colored, cprint

# https://stackoverflow.com/questions/29858752/error-message-chromedriver-executable-needs-to-be-available-in-the-path
# https://www.selenium.dev/selenium/docs/api/py/index.html

def loginSmartControlUserTestCase(Username, Password):
    
    global driver

    try:
        
        # To download ChromeDriver automaticly
        #driver = webdriver.Chrome(ChromeDriverManager().install())
        driver = webdriver.Chrome()

        #navigate to the url  
        driver.get("http://smartcontrol.mitechnologiesinc.com/")  

        time.sleep(1)
        driver.find_element_by_id("inputUser").send_keys(Username)  
        
        driver.find_element_by_id("inputPassword").send_keys(Password)
        

        # Cick on Login Button
        driver.find_element_by_xpath("//button").click()
        
        time.sleep(1)
        DashboardScreen = driver.find_elements_by_xpath("//div[@id='site-navbar-collapse']/ul[2]/li[2]/a")
        wasfund = len(DashboardScreen)

        if wasfund > 0:
            print(colored('SuccessLogin', 'green'))
            pass
        else:
            print(colored('LoginFailed', 'red'))
            pass
        
        pass
    except: # Catch all exceptions
        Catchederror = sys.exc_info()[0]
        print(Catchederror)
        pass   
    pass

def  main():
    loginSmartControlUserTestCase ("user.name", "password")
    pass

if __name__ == "__main__":
    main()
