    
    var asins = new Array()
    var authors = new Array()
    var titles = new Array()
    var files = new Array()
    
    function showCopyright() {
        var date = new Date();
        var year = date.getYear();
        if (year < 1900) {
          year = year+1900;
        }
        document.write('Copyright &#169; 1999-' + year + ', Ronald E Jeffries<br/><br/>');
    }


    function showBookReview(){
        var bookIndex = Math.round(Math.random()*(asins.length-1));
        showBook(bookIndex,true); 
    }
    
    function showRonBook(){
      var actionIndex = Math.round(Math.random()*3);
      if (actionIndex <= 1) {
        showBook(findAsin("0735619492"), true);
      }
      else {
        showBook(findAsin("0201708426"), true); 
      }
    }
    
    function findAsin(asinString) {
      for ( var i = 0; i < asins.length; i++ ) {
        if (asins[i] == asinString ) {
          return i;
        }
      }
      return 1;
    }
    
    function showImage(){
      var actionIndex = Math.round(Math.random()*3);
      if (actionIndex <= 1) {
        showSpecial();
      }
      else {
        var bookIndex = Math.round(Math.random()*(asins.length-1));
        showBook(bookIndex,true); 
      }
    }
    
    function showSpecial() {
      var adOrBook = Math.round(Math.random());
      if (adOrBook >= 1) {
        showServices()
      }
      else {
        showAdventures();
      }
    }
    
    function showServices() {
      document.write('<a href="xpmag/services.htm">');
      document.write('<img border="1" src="images/ron100.jpg" alt="ron picture">');
      document.write('</a>');
      document.write('<font color="red">');
      document.write('<a href="xpmag/services.htm"><P class="booktitleindex"><br/><b>XProgramming.com Services</b></P></a>');
      document.write('</font>');
      document.write('<P class="booktitleindex"><b>Let Ron Jeffries, experienced XP author, trainer, coach, and practitioner, put together a combination of training and services that is just right for you.</b></P>');
      document.write('</font>');
    }
    
    function showAdventures() {
      var adventuresIndex = findAdventures();
      showBook(adventuresIndex,true);
    }
    
    function findAdventures() {
      for ( var i = 0; i < asins.length; i++ ) {
        if (asins[i] == "0735619492" ) {
          return i;
        }
      }
      return 1;
    }
    
    /* Rescales image if width too large */ 
    function setDimensions(img) {
      var imgWidth = img.width;
      var imgHeight = img.height;
      var maxWidth = 120
      if (img.width > maxWidth)
        {
          imgWidth = maxWidth;
          imgHeight = (img.height * imgWidth) / img.width;
          return 'width=' + imgWidth + ' height=' + imgHeight;
        }
        return ' '
    }

    function showBook(bookIndex, resize) {
      /* preloads image */
      var img = new Image(); 
      img.src = 'http://www.xprogramming.com/images/'
       + asins[bookIndex]
       + '.jpg';
      
      /* sets dimension attributes */
      if (resize) {
          var imgDimensions = setDimensions(img);
      }
      else {
          var imgDimensions = "";
      } 

      var href = 
      '<a href="http://www.xprogramming.com/xpmag/'
      + files[bookIndex]
      + '#book'
      + asins[bookIndex]
      + '" class="booktitleindex">';

      var imgTag =
       '<img border="0" src="http://www.xprogramming.com/images/'
       + asins[bookIndex]
       + '.jpg" alt="book cover" align="center" '
       + imgDimensions
       + '>';
      
     document.write(
      href
      + imgTag 
      + '</a>'
      );
      
    document.write(
       href
      + '<P class="booktitleindex"><strong>'
      + titles[bookIndex]
      + '</strong> <br>'
      + '<span class="author">'
      + authors[bookIndex]
      + '</span></P>'
      + '</a>'
      );
    } 

