<h1>Simple SpringBoot Rest Service</h1>

<p>Aplication returns image according to a search term.</br>
    The image can be returned from 2 places: Database / pixabay API</p>
<p>- /getAllImages - returns list of all images in database</p>
<p>- /getImage/{term} - returns image by term. If term not exist in DB. Adding to DB value that received from
    pixabay</br></p>
<p>Url example:</br>
    https://pixabay.com/api/?key=GENERATED_KEY&q=yellow+flowers&image_type=photo&pretty=true</p>
