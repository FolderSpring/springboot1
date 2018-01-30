<h1>Simple SpringBoot Rest Service</h1>

<p>Aplication returns image according to a search term.</br>
    The image can be returned from 2 places: Database / pixabay API</p>
<p>- / - info about service
<p>- /getAllImages - returns list of all images in database</p>
<p>- /getImage/{term} - returns image by term. If term not exist in DB. Adding to DB value that received from
    pixabay</br></p>
<p>Url example:</br>
    https://pixabay.com/api/?key=GENERATED_KEY&q=yellow+flowers&image_type=photo&pretty=true</p>
    
<h1>IMPORTANT</h1>
<p>- Insert into Constants class generated key</p>
<p>- ADD cer to cacerts:</br>
Run command line from administrator:</br>
> keytool -import -file "C:\pixabay.cer" -keystore "C:\Program Files\Java\jdk1.8.0_77\jre\lib\security\cacerts" -alias "pixabay certificate"</br>
Show if exist certificate with alias</br>
> keytool -list -keystore "C:\Program Files\Java\jdk1.8.0_77\jre\lib\security\cacerts" -alias "pixabay certificate"
</p>
