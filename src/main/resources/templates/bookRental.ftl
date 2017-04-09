<div class="generic-container">
	<row>
        <td><button ng-disabled="ctrl.showAll" type="button" ng-click="ctrl.all()" class="btn btn-info custom-width">Kataloog</button></td>
        <td><button ng-disabled="ctrl.showAvailable" type="button" ng-click="ctrl.available()" class="btn btn-info custom-width">Laenutus</button></td>
        <td><button ng-disabled="ctrl.showRented" type="button" ng-click="ctrl.rented()" class="btn btn-info custom-width">Tagastus</button></td>
	</row>

	<#---->

    <div ng-show="ctrl.showAll"class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Kõik raamatud</span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>ID</th>
		                <th>PEALKIRI</th>
		                <th>AUTOR</th>
		                <th width="100">OLEK</th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="u in ctrl.getAllBooks()">
		                <td>{{u.id}}</td>
		                <td>{{u.title}}</td>
                        <td>{{u.author}}</td>
		                <td class="btn-success custom-width" ng-show="!u.rentedout"></td>
		                <td class="btn-danger custom-width" ng-show="u.rentedout">Välja laenutatud</td>
		            </tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>

	<#---->

        <div ng-show="ctrl.showAvailable" class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">Saadaval olevad raamatud</span></div>
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>PEALKIRI</th>
                            <th>AUTOR</th>
                            <th>LAENUTUSINFO</th>
                            <th width="100"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr ng-show="!u.rentedout" ng-repeat="u in ctrl.getAllBooks()">
                                <td>{{u.id}}</td>
                                <td>{{u.title}}</td>
                                <td>{{u.author}}</td>
                                <td>
                                    <input type="text" ng-model="u.comment" id="uname" class="username form-control input-sm" placeholder='Laenutamiseks kirjuta siia laenutusinfo ning seejärel vajuta nuppu "Laenuta"' required ng-minlength="3"/>
                                </td>
                                <td><button ng-disabled="u.rentedout" type="button" ng-click="ctrl.rentBook(u)" class="btn btn-success custom-width">Laenuta</button></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
<#---->
        <div ng-show="ctrl.showRented" class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">Välja laenutatud raamatud</span></div>
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>PEALKIRI</th>
                            <th>AUTOR</th>
                            <th>LAENUTUSINFO</th>
                            <th>LAENUTAMISE KUUPÄEV</th>
                            <th width="100"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr ng-show="u.rentedout" ng-repeat="u in ctrl.getAllBooks()">
                                <td>{{u.id}}</td>
                                <td>{{u.title}}</td>
                                <td>{{u.author}}</td>
                                <td>{{u.comment}}</td>
                                <td>{{u.rentingdate}}</td>
                                <td>
                                    <button ng-disabled="!u.rentedout" type="button" ng-click="ctrl.rentBook(u)" class="btn btn-danger custom-width">
                                        Tagasta</button>
                                </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
</div>