## Recipe organizer

A collection of recipes organized by various categories such as country, alphabet, ingredients, allergies, and dietary preferences like vegan, pescatarian, and vegetarian. This categorization allows users to conveniently search for recipes based on their specific requirements and preferences. By organizing recipes in this manner, users can easily explore new recipes and enhance their culinary skills. Such catalogs provide a comprehensive resource for individuals looking to try out new dishes or find inspiration for their cooking endeavors. They can be accessed through various mediums such as websites, cookbooks, or digital applications.

https://www.themealdb.com/api.php

![screenshot of using a tool to try out the API]([https://github.com/jewwoo/Three-Musketeers/blob/main/example%20output.png](https://github.com/jewwoo/Three-Musketeers/blob/main/screenshot%20of%20using%20a%20tool%20to%20try%20out%20the%20API.png))


![screenshot of example output of running your Java code](https://github.com/jewwoo/Three-Musketeers/blob/main/example%20output.png)


### Example output:
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>TheMealDB.com</title>
	<!-- CSS Scripts -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/font-awesome.min.css" rel="stylesheet">
    <link href="/css/animate.min.css" rel="stylesheet">
    <link href="/css/prettyPhoto.css" rel="stylesheet">
    <link href="/css/main.css" rel="stylesheet">
    <link href="/css/responsive.css" rel="stylesheet">
	<!-- Favicon Includes -->
	<link rel="apple-touch-icon" sizes="180x180" href="/images/icons/favicon/apple-touch-icon.png">
	<link rel="icon" type="image/png" sizes="32x32" href="/images/icons/favicon/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="16x16" href="/images/icons/favicon/favicon-16x16.png">
	<link rel="manifest" href="/images/icons/favicon/site.webmanifest">
	<link rel="mask-icon" href="/images/icons/favicon/safari-pinned-tab.svg" color="#5bbad5">
	<meta name="msapplication-TileColor" content="#da532c">
	<meta name="theme-color" content="#ffffff">
</head>

<body class="homepage">

<header id="header">
    <nav class="navbar navbar-inverse" role="banner">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="https://www.themealdb.com"><img src="../images/logo-small.png" alt="logo"></a>
            </div>
				
            <div class="collapse navbar-collapse navbar-right">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="https://www.themealdb.com">Home</a></li>
                    <li><a href="\api.php">API</a></li>
                    <li>
						<div class="search">
                            <form role="form" action="../browse.php">
								<input type="text" name="s" class="search-form" autocomplete="off" placeholder=" Search"  />
                            </form>
                        </div>
					</li>
				</ul>
            </div>
        </div><!--/.container-->
    </nav><!--/nav-->
</header><!--/header-->
<div class="container"></div>

<section id="feature" >

	<div class="container">
	<div class="center">
    
<table style="width:100%">
	<tr>
        <td style="width:20%">
			<img src="/images/meal-icon.png" style="max-width: 100%;height: auto;" alt="Plate Left" />
		</td>
		<td>
			<h1>Welcome to TheMealDB</h1>
            Welcome to TheMealDB: An open, crowd-sourced database of Recipes from around the world.<br>
			We also offer a <a href='/api.php'/>free JSON API</a> for anyone wanting to use it, with additional features for subscribers.<br>
			
			<!-- If you like the site, please consider supporting us on Patreon by clicking the link below...<br>
            <a href="https://www.patreon.com/thedatadb"/><img src="/images/patreon_logo.png" style="width:200px;"><br>-->
			<center><table><tr><td text-align ='center' width='100'/>
			<div id="paypal-button-container-P-5A138037KG443451XMHIZ3SY"></div>
			<script src="https://www.paypal.com/sdk/js?client-id=AfHEVYLvvBE2km3eTSHJwF2A6W2YN3CZE--80QyFC7m92Nob4rcZlpzLj-hfcVQGEyBwQombwraLOaEb&vault=true&intent=subscription" data-sdk-integration-source="button-factory"></script>
			<script>
				paypal.Buttons({
					style: {
						shape: 'rect',
						color: 'gold',
						layout: 'horizontal',
						height: 32,
						width: 45,
						label: ''
					},
				createSubscription: function(data, actions) {
					return actions.subscription.create({
					/* Creates the subscription */
						plan_id: 'P-05C643823H4633638MRJ35TI'
					});
				},
				onApprove: function(data, actions) {
					alert(data.subscriptionID); // You can add optional success message for the subscriber here
				}
				}).render('#paypal-button-container-P-5A138037KG443451XMHIZ3SY');
			</script>
			
			</td></tr></table></center>
			Click button above to upgrade free API to premium for $3<br>
			Currently 76 supporters<br><br>
        </td>
        <td style="width:20%">
			<img src="/images/meal-icon.png"  style="max-width: 100%;height: auto;" alt="Plate Right" />
		</td>
	</tr>
</table>

<img src="/images/separator.jpg" style="width: 100%; object-fit: contain"><br>

	<table width="350" align="center">
		<tr>
			<td>
				<form class="navbar-form" action="../browse.php" autocomplete="off">
					<div class="input-group">
					<input type="text" name="s" class="form-control" autocomplete="off" placeholder="Search for a Meal..."  />
					<div class="input-group-btn">
						<button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
					</div>
					</div>
				</form>
			</td>
		</tr>
	</table>
	<img src='images/icons/meal-icon6.png' /> <b>Total Meals: </b> 295<img src='images/transparent.png' width='10' height='1' /><img src='images/icons/meal-icon4.png' /> <b>Total Ingredients: </b>574<img src='images/transparent.png' width='10' height='1' /><img src='images/icons/image2.png' /> <b>Images: </b>295
	</div>
	<img src="/images/separator.jpg" style="width: 100%; object-fit: contain"><br>
    </div>    
    <div class="container">
        <div class="center">
            <h3> Latest Meals </h3>
            <div class='row'><div class='col-sm-3'><a href='/meal/53076-Bread-omelette-Recipe'><img src= 'https://www.themealdb.com/images/media/meals/hqaejl1695738653.jpg' width='95%'/>Bread omelette</a><br><br></div><div class='col-sm-3'><a href='/meal/53075-Tortang-Talong-Recipe'><img src= 'https://www.themealdb.com/images/media/meals/va668f1683209318.jpg' width='95%'/>Tortang Talong</a><br><br></div><div class='col-sm-3'><a href='/meal/53074-Grilled-eggplant-with-coconut-milk-Recipe'><img src= 'https://www.themealdb.com/images/media/meals/bopa2i1683209167.jpg' width='95%'/>Grilled eggplant with coconut milk</a><br><br></div><div class='col-sm-3'><a href='/meal/53073-Eggplant-Adobo-Recipe'><img src= 'https://www.themealdb.com/images/media/meals/y7h0lq1683208991.jpg' width='95%'/>Eggplant Adobo</a><br><br></div></div><div class='row'><div class='col-sm-3'><a href='/meal/53072-Crispy-Eggplant-Recipe'><img src= 'https://www.themealdb.com/images/media/meals/c7lzrl1683208757.jpg' width='95%'/>Crispy Eggplant</a><br><br></div><div class='col-sm-3'><a href='/meal/53071-Beef-Asado-Recipe'><img src= 'https://www.themealdb.com/images/media/meals/pkopc31683207947.jpg' width='95%'/>Beef Asado</a><br><br></div><div class='col-sm-3'><a href='/meal/53070-Beef-Caldereta-Recipe'><img src= 'https://www.themealdb.com/images/media/meals/41cxjh1683207682.jpg' width='95%'/>Beef Caldereta</a><br><br></div><div class='col-sm-3'><a href='/meal/53069-Bistek-Recipe'><img src= 'https://www.themealdb.com/images/media/meals/4pqimk1683207418.jpg' width='95%'/>Bistek</a><br><br></div>			</div>
			<br><br>
			<img src="/images/separator.jpg" style="width: 100%; object-fit: contain"><br>
			
			<h3>Popular Ingredients</h3>
            <div class='row'><div class='col-sm-3'>
						<a href='ingredient.php?c=1' />
						<figure>						
						<img src= '/images/ingredients/Chicken.png' width='95%'/>
						<figcaption><br>Chicken</figcaption>
						</figure>
					</a></div><div class='col-sm-3'>
						<a href='ingredient.php?c=2' />
						<figure>						
						<img src= '/images/ingredients/Salmon.png' width='95%'/>
						<figcaption><br>Salmon</figcaption>
						</figure>
					</a></div><div class='col-sm-3'>
						<a href='ingredient.php?c=3' />
						<figure>						
						<img src= '/images/ingredients/Beef.png' width='95%'/>
						<figcaption><br>Beef</figcaption>
						</figure>
					</a></div><div class='col-sm-3'>
						<a href='ingredient.php?c=4' />
						<figure>						
						<img src= '/images/ingredients/Pork.png' width='95%'/>
						<figcaption><br>Pork</figcaption>
						</figure>
					</a></div>			</div>
			<br>
			<img src="/images/separator.jpg" style="width: 100%; object-fit: contain"><br>

			<h3>Random Meals</h3>
            <div class='row'><div class='col-sm-3'><a href='/meal/52934-Chicken-Basquaise-Recipe'><div><img src= 'https://www.themealdb.com/images/media/meals/wruvqv1511880994.jpg' width='95%' /></div>Chicken Basquaise</a><br><br></div><div class='col-sm-3'><a href='/meal/53052-Roti-john-Recipe'><div><img src= 'https://www.themealdb.com/images/media/meals/hx335q1619789561.jpg' width='95%' /></div>Roti john</a><br><br></div><div class='col-sm-3'><a href='/meal/52836-Seafood-fideuà-Recipe'><div><img src= 'https://www.themealdb.com/images/media/meals/wqqvyq1511179730.jpg' width='95%' /></div>Seafood fideuà</a><br><br></div><div class='col-sm-3'><a href='/meal/53014-Pizza-Express-Margherita-Recipe'><div><img src= 'https://www.themealdb.com/images/media/meals/x0lk931587671540.jpg' width='95%' /></div>Pizza Express Margherita</a><br><br></div></div><div class='row'><div class='col-sm-3'><a href='/meal/52951-General-Tsos-Chicken-Recipe'><div><img src= 'https://www.themealdb.com/images/media/meals/1529444113.jpg' width='95%' /></div>General Tso's Chicken</a><br><br></div><div class='col-sm-3'><a href='/meal/52842-Broccoli-&-Stilton-soup-Recipe'><div><img src= 'https://www.themealdb.com/images/media/meals/tvvxpv1511191952.jpg' width='95%' /></div>Broccoli & Stilton soup</a><br><br></div><div class='col-sm-3'><a href='/meal/53037-Coddled-pork-with-cider-Recipe'><div><img src= 'https://www.themealdb.com/images/media/meals/7vpsfp1608588991.jpg' width='95%' /></div>Coddled pork with cider</a><br><br></div><div class='col-sm-3'><a href='/meal/52917-White-chocolate-creme-brulee-Recipe'><div><img src= 'https://www.themealdb.com/images/media/meals/uryqru1511798039.jpg' width='95%' /></div>White chocolate creme brulee</a><br><br></div>			</div>
			
			<img src="/images/separator.jpg" style="width: 100%; object-fit: contain"><br>
			
			<div class="center">
			<h3>Random Ingredients</h3>
			<div class='row'><div class='col-sm-3'>
						<a href='ingredient.php?c=398' />
						<figure>						
						<img src= '/images/ingredients/Pinto Beans.png' width='95%'/>
						<figcaption><br>Pinto Beans</figcaption>
						</figure>
					</a></div><div class='col-sm-3'>
						<a href='ingredient.php?c=523' />
						<figure>						
						<img src= '/images/ingredients/Doubanjiang.png' width='95%'/>
						<figcaption><br>Doubanjiang</figcaption>
						</figure>
					</a></div><div class='col-sm-3'>
						<a href='ingredient.php?c=546' />
						<figure>						
						<img src= '/images/ingredients/Almond Milk.png' width='95%'/>
						<figcaption><br>Almond Milk</figcaption>
						</figure>
					</a></div><div class='col-sm-3'>
						<a href='ingredient.php?c=145' />
						<figure>						
						<img src= '/images/ingredients/Freshly Chopped Parsley.png' width='95%'/>
						<figcaption><br>Freshly Chopped Parsley</figcaption>
						</figure>
					</a></div>		<br><br>
		<img src="/images/separator.jpg" style="width: 100%; object-fit: contain"><br>
		</div>

			<h3> Browse Country </h3>
            
				<a href='/browse.php?a=British'>
				<img src='/images/icons/flags/big/64/gb.png'></a>
				
				<a href='/browse.php?a=American'>
				<img src='/images/icons/flags/big/64/us.png'></a>
				
				<a href='/browse.php?a=French'>
				<img src='/images/icons/flags/big/64/fr.png'></a>
				
				<a href='/browse.php?a=Canadian'>
				<img src='/images/icons/flags/big/64/ca.png'></a>
				
				<a href='/browse.php?a=Jamaican'>
				<img src='/images/icons/flags/big/64/jm.png'></a>
				
				<a href='/browse.php?a=Chinese'>
				<img src='/images/icons/flags/big/64/cn.png'></a>
				
				<a href='/browse.php?a=Dutch'>
				<img src='/images/icons/flags/big/64/nl.png'></a>
				
				<a href='/browse.php?a=Egyptian'>
				<img src='/images/icons/flags/big/64/eg.png'></a>
				
				<a href='/browse.php?a=Greek'>
				<img src='/images/icons/flags/big/64/gr.png'></a>
				
				<a href='/browse.php?a=Indian'>
				<img src='/images/icons/flags/big/64/in.png'></a>
				
				<a href='/browse.php?a=Irish'>
				<img src='/images/icons/flags/big/64/ie.png'></a>
				
				<a href='/browse.php?a=Italian'>
				<img src='/images/icons/flags/big/64/it.png'></a>
				
				<a href='/browse.php?a=Japanese'>
				<img src='/images/icons/flags/big/64/jp.png'></a>
				
				<a href='/browse.php?a=Kenyan'>
				<img src='/images/icons/flags/big/64/kn.png'></a>
				
				<a href='/browse.php?a=Malaysian'>
				<img src='/images/icons/flags/big/64/my.png'></a>
				
				<a href='/browse.php?a=Mexican'>
				<img src='/images/icons/flags/big/64/mx.png'></a>
				
				<a href='/browse.php?a=Moroccan'>
				<img src='/images/icons/flags/big/64/ma.png'></a>
				
				<a href='/browse.php?a=Croatian'>
				<img src='/images/icons/flags/big/64/hr.png'></a>
				
				<a href='/browse.php?a=Norwegian'>
				<img src='/images/icons/flags/big/64/no.png'></a>
				
				<a href='/browse.php?a=Portuguese'>
				<img src='/images/icons/flags/big/64/pt.png'></a>
				
				<a href='/browse.php?a=Russian'>
				<img src='/images/icons/flags/big/64/ru.png'></a>
				
				<a href='/browse.php?a=Argentinian'>
				<img src='/images/icons/flags/big/64/ar.png'></a>
				
				<a href='/browse.php?a=Spanish'>
				<img src='/images/icons/flags/big/64/es.png'></a>
				
				<a href='/browse.php?a=Slovakian'>
				<img src='/images/icons/flags/big/64/sk.png'></a>
				
				<a href='/browse.php?a=Thai'>
				<img src='/images/icons/flags/big/64/th.png'></a>
				
				<a href='/browse.php?a=Saudi Arabian'>
				<img src='/images/icons/flags/big/64/sa.png'></a>
				
				<a href='/browse.php?a=Vietnamese'>
				<img src='/images/icons/flags/big/64/vn.png'></a>
				
				<a href='/browse.php?a=Turkish'>
				<img src='/images/icons/flags/big/64/tr.png'></a>
				
				<a href='/browse.php?a=Syrian'>
				<img src='/images/icons/flags/big/64/sy.png'></a>
				
				<a href='/browse.php?a=Algerian'>
				<img src='/images/icons/flags/big/64/dz.png'></a>
				
				<a href='/browse.php?a=Tunisian'>
				<img src='/images/icons/flags/big/64/tn.png'></a>
				
				<a href='/browse.php?a=Polish'>
				<img src='/images/icons/flags/big/64/pl.png'></a>
				
				<a href='/browse.php?a=Filipino'>
				<img src='/images/icons/flags/big/64/ph.png'></a>
				
            <br><br>
            <h3> Browse By Name<br></h3>
			<h2> 
			<a href='/browse.php?b=a'/>A</a> / <a href='/browse.php?b=b'/>B</a> / <a href='/browse.php?b=c'/>C</a> / <a href='/browse.php?b=d'/>D</a> / <a href='/browse.php?b=e'/>E</a> / <a href='/browse.php?b=f'/>F</a> / <a href='/browse.php?b=g'/>G</a> / <a href='/browse.php?b=h'/>H</a> / <a href='/browse.php?b=i'/>I</a> / <a href='/browse.php?b=j'/>J</a> / <a href='/browse.php?b=k'/>K</a> / <a href='/browse.php?b=l'/>L</a> / <a href='/browse.php?b=m'/>M</a> / <a href='/browse.php?b=n'/>N</a> / <a href='/browse.php?b=o'/>O</a> / <a href='/browse.php?b=p'/>P</a> / <a href='/browse.php?b=q'/>Q</a> / <a href='/browse.php?b=r'/>R</a> / <a href='/browse.php?b=s'/>S</a> / <a href='/browse.php?b=t'/>T</a> / <a href='/browse.php?b=u'/>U</a> / <a href='/browse.php?b=v'/>V</a> / <a href='/browse.php?b=w'/>W</a> / <a href='/browse.php?b=x'/>X</a> / <a href='/browse.php?b=y'/>Y</a> / <a href='/browse.php?b=z'/>Z</a>			</h2>
			</div>
        </div><!--/.container-->
    </section><!--/#feature-->

<footer id="footer" class="midnight-blue">
        <div class="container">
            <div class="row">
                <div class="col-sm-3">
                    &copy; 2023 TheMealDB</a> <br>Proudly built in the UK <img src='/images/icons/flags/big/16/gb.png'/>
                </div>
                <div class="col-sm-6">
					<center>
						Socials: 
						<a href="https://www.facebook.com/TheDataDB/"><img src="../images/facebook_icon.png"></a> 
						<a href="https://twitter.com/TheAudioDB"><img src="../images/twitter_icon.png"></a>
						<a href="https://discord.com/invite/pFvgaXV"><img src="../images/discord_icon.png"></a><br><br>
						<a href="https://www.thecocktaildb.com" target="_blank"><img src="../images/logo-tcdb.png" alt="logo"></a>
						<a href="http://www.theaudiodb.com" target="_blank"><img src="../images/logo-tadb.png" alt="logo"></a>
						<a href="https://www.thesportsdb.com" target="_blank"><img src="../images/logo-tsdb.png" alt="logo"></a>
					</center>
				</div>
                <div class="col-sm-3">
                    <ul class="pull-right">
                        <li><a href="../about.php">About</a></li>
                        <li><a href="../faq.php">Faq</a></li>
                        <li><a href="../contact.php">Contact</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </footer><!--/#footer-->    <script src="../js/jquery.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/jquery.prettyPhoto.js"></script>
    <script src="../js/jquery.isotope.min.js"></script>
    <script src="../js/main.js"></script>
 
<script defer src="https://static.cloudflareinsights.com/beacon.min.js/v8b253dfea2ab4077af8c6f58422dfbfd1689876627854" integrity="sha512-bjgnUKX4azu3dLTVtie9u6TKqgx29RBwfj3QXYt5EKfWM/9hPSAI/4qcV5NACjwAo8UtTeWefx6Zq5PHcMm7Tg==" data-cf-beacon='{"rayId":"80e95b0e6ad236a3","version":"2023.8.0","r":1,"b":1,"token":"71aba6f2a0a5452cb38879a0173f1037","si":100}' crossorigin="anonymous"></script>
</body>
</html>








