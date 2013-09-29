// Set our defaults. 
if(!window.amazon_ad_width) { amazon_ad_width = 728; }
if(!window.amazon_ad_height) { amazon_ad_height = 90; }
if(!window.amazon_ad_tag) { amazon_ad_tag = ""; }
if(!window.amazon_ad_price) { amazon_ad_price = "all"; }
if(!window.amazon_ad_border) { amazon_ad_border = 'show'; }
if(!window.amazon_ad_logo) { amazon_ad_logo = 'show'; }
if(!window.amazon_ad_product_images) { amazon_ad_product_images = 'show'; }
if(!window.amazon_ad_link_target) { amazon_ad_link_target = "same"; }
if(!window.amazon_ad_referrer) { amazon_ad_referrer = "current"; }
if(!window.amazon_ad_discount) { amazon_ad_discount = "add"; }

amazon_pvid();  

// Write the iframe
document.write('<ifr' + 'ame src="' + amazon_generate_url() + '" marginwidth="0" marginheight="0" width="' + amazon_ad_width + '" height="' + amazon_ad_height + '" border="0" frameborder="0" style="border:none;" scrolling="no"></iframe>');

// Flush parameters after render to restore defaults.
amazon_ad_width = null;
amazon_ad_height = null;
amazon_ad_price = null;
amazon_ad_border = null;
amazon_ad_logo = null;
amazon_ad_product_images = null;
amazon_ad_link_target = null;
amazon_ad_referrer = null;
amazon_ad_exclude = null;
amazon_ad_include = null;
amazon_ad_categories = null;
amazon_ad_discount = null;

//-------------
// HELPER FUNCTIONS
//-------------
function amazon_generate_url()
{
  // Common stuff
  var amazon_q = "http://" + amazon_ad_rcm + "/e/cm?";
  amazon_q += "t=" + amazon_ad_tag; 
  amazon_q += "&o=" + amazon_ad_o;
  amazon_q += "&p=" + amazon_p(amazon_ad_width,amazon_ad_height);
  amazon_q += "&l=op1";
  amazon_q += "&pvid=" + amazon_ad_pvid;

  // Referring URL should be the parent location if the ad page is within an iframe.
  amazon_q += "&ref-url=" + escape((amazon_iframe() || (amazon_ad_referrer == 'parent')) ? document.referrer : document.location);

  // Colors
  amazon_q+="&bgc="+amazon_fix_color(window.amazon_color_background, "FFFFFF");
  amazon_q+="&bdc="+amazon_fix_color(window.amazon_color_border, "000000");
  amazon_q+="&pcc="+amazon_fix_color(window.amazon_color_price, "990000");
  amazon_q+="&tec="+amazon_fix_color(window.amazon_color_text, "000000");
  amazon_q+="&tic="+amazon_fix_color(window.amazon_color_link, "3399FF");
  amazon_q+="&ac=" +amazon_fix_color(window.amazon_color_logo, "CC6600");

  // Display options
  if(amazon_ad_price=="all") {amazon_q+="&mp=1";}
  if(amazon_ad_border=='hide') {amazon_q+="&hb=1";}
  if(amazon_ad_logo=='hide') {amazon_q+="&hl=1";}
  if(amazon_ad_product_images=='hide') {amazon_q+="&hp=1";}
  if(amazon_ad_link_target=="new") {amazon_q+="&tg=_blank";}
  if(amazon_ad_discount=="add") {amazon_q+="&dsc=1";}

  // Advanced options
  if(window.amazon_ad_exclude)
  {
      amazon_q += '&exwords=' + filterKeywords(amazon_ad_exclude);
  }

  if(window.amazon_ad_include) 
  {
      amazon_q += '&inwords=' + filterKeywords(amazon_ad_include);
  }
  
  if(window.amazon_ad_categories) {amazon_q+='&incats='+amazon_ad_categories;}

  amazon_q += '&f=ifr';
  var e = (document.characterSet) ? document.characterSet : document.charset;
  if (e) { amazon_q += '&e='+e.toLowerCase(); }

  return amazon_q;
}

//takes a string keywords argument and makes sure it only contains
//the allowed number of phrases
function filterKeywords(keywords)
{
    var keyword_limit = 5;
    
    var rtn_keywords;
    if(keywords)
    {
        var items = keywords.split(/;/);
        if (items.length > keyword_limit)
        {
            items = items.slice(0,keyword_limit);
            rtn_keywords  = items.join(';');
        }
        else
        {
            rtn_keywords = keywords;
        }
    }
    
    return rtn_keywords;
}

function amazon_p(w, h)
{
  var p = new Array();
  p["120x150"] = 6;
  p["120x240"] = 8;
  p["180x150"] = 9;
  p["120x450"] = 10;
  p["120x600"] = 11;
  p["300x250"] = 12;
  p["468x60"] = 13;
  p["160x600"] = 14;
  p["468x240"] = 15;
  p["468x336"] = 16;
  p["600x520"] = 36;
  p["728x90"] = 48;
  
  return p[w + "x" + h];
}

function amazon_iframe()
{
  var rval = false;
  if (document.body)
  {
    rval = ((document.referrer != '') && ((document.body.clientWidth < (1.5 * amazon_ad_width)) && (document.body.clientHeight < (1.5 * amazon_ad_height))));
  }
  else if (document.documentElement)
  {
    rval = ((document.referrer != '') && ((document.documentElement.clientWidth < (1.5 * amazon_ad_width)) && (document.documentElement.clientHeight < (1.5 * amazon_ad_height))));
  }
  return rval;
}

function amazon_fix_color($color, $dflt)
{
  if(!$color) { return $dflt; }
  if($color.length != 6) { return $dflt; }
  $color = $color.toUpperCase();
  var $h2d = "0123456789ABCDEF";
  for(i = 0; i < 6; i++)
  {
    var $x = $color.charAt(i);
    if($h2d.indexOf($x) == -1 )
    {
      return $dflt;
    }
  }
  return $color;
}

function amazon_pvid()
{
  if(window.amazon_ad_pvid)
  {
    return amazon_ad_pvid;
  }

  amazon_ad_pvid = "";

  var $h2d = "0123456789ABCDEF";
  for(i = 0; i < 16; i++)
  {
    amazon_ad_pvid += $h2d.charAt(Math.floor( 16 * Math.random() ));
  }
}
