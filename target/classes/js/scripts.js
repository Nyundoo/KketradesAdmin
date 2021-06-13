/**
 * 
 */

$(document).ready(function() {
	$('.delete-customer').on('click', function (){
		/*<![CDATA[*/
	    var path = /*[[@{/}]]*/'remove';
	    /*]]>*/
		
		var id=$(this).attr('id');
		
		bootbox.confirm({
			message: "Are you sure to remove this customer? It can't be undone.",
			buttons: {
				cancel: {
					label:'<i class="fa fa-times"></i> Cancel'
				},
				confirm: {
					label:'<i class="fa fa-check"></i> Confirm'
				}
			},
			callback: function(confirmed) {
				if(confirmed) {
					$.post(path, {'id':id}, function(res) {
						location.reload();
					});
				}
			}
		});
	});
	
	
	
//	$('.checkboxCustomer').click(function () {
//        var id = $(this).attr('id');
//        if(this.checked){
//            customerIdList.push(id);
//        }
//        else {
//            customerIdList.splice(customerIdList.indexOf(id), 1);
//        }
//    })
	
	$('#deleteSelected').click(function() {
		var idList= $('.checkboxCustomer');
		var customerIdList=[];
		for (var i = 0; i < idList.length; i++) {
			if(idList[i].checked==true) {
				customerIdList.push(idList[i]['id'])
			}
		}
		
		console.log(customerIdList);
		
		/*<![CDATA[*/
	    var path = /*[[@{/}]]*/'removeList';
	    /*]]>*/
	    
	    bootbox.confirm({
			message: "Are you sure to remove all selected customers? It can't be undone.",
			buttons: {
				cancel: {
					label:'<i class="fa fa-times"></i> Cancel'
				},
				confirm: {
					label:'<i class="fa fa-check"></i> Confirm'
				}
			},
			callback: function(confirmed) {
				if(confirmed) {
					$.ajax({
						type: 'POST',
						url: path,
						data: JSON.stringify(customerIdList),
						contentType: "application/json",
						success: function(res) {
							console.log(res); 
							location.reload()
							},
						error: function(res){
							console.log(res); 
							location.reload();
							}
					});
				}
			}
		});
	});
	
	$("#selectAllCustomers").click(function() {
		if($(this).prop("checked")==true) {
			$(".checkboxCustomer").prop("checked",true);
		} else if ($(this).prop("checked")==false) {
			$(".checkboxCustomer").prop("checked",false);
		}
	})
});