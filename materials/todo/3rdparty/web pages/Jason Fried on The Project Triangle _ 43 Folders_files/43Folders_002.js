
				var fStartPost = 1;

				if (window.feedburner_currPost!=null) {
					window.feedburner_currPost++;
				} else {
					window.feedburner_currPost=1;
				}

				//legacy check for attribute instead of preferred Global var
				//A VC and precious few others use this
			    if (document.body.getAttribute("fStartPost")) {
			        fs = parseInt(document.body.getAttribute("fStartPost"));
			        if (!isNaN(fs)) fStartPost = fs
			    }	

				//for wide distribution
				if (window.feedburner_startPostOverride != null) {
					fs = parseInt(window.feedburner_startPostOverride);
					if (!isNaN(fs)) fStartPost = window.feedburner_startPostOverride;
				} else {
					window.feedburner_startPostOverride = fStartPost;
				}

				if (window.feedburner_currPost == fStartPost)  {
	              feedSrc = 'http://feeds.feedburner.com/~s/43Folders?i=' + escape("http://www.43folders.com/2005/04/01/jason-fried-on-the-project-triangle/") + '&showad=true'
	              document.write('<script src=\"' + feedSrc + '\" type=\"text/javascript\"></script>');
				}

            
if( typeof(FBSiteTrackerUri) == "undefined" || typeof(FBSiteTrackerURI) == "unknown" ) {
 var FBSiteTrackerUri = "43Folders";
 document.write('<script type="text/javascript" charset="utf-8" src="http://feeds.feedburner.com/~d/static/site-tracker.js"></script>');
}     	
    	