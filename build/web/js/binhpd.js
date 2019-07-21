/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function putNameFieldsIndex()
{
    journeyParent = document.getElementsByClassName("journey-container");
    var j;
    for (j = 0; j < journeyParent.length; j++)
    {
        var journeyContainer = journeyParent[j];
        var journeyInputs = journeyContainer.getElementsByTagName('input');
        for (var i = 0; i < journeyInputs.length; i++) {
            journeyInputs[i].name = journeyInputs[i].name + j;
        }
        var journeyTextAreas = journeyContainer.getElementsByTagName('textarea');
        for (var i = 0; i < journeyTextAreas.length; i++) {
            journeyTextAreas[i].name = journeyTextAreas[i].name + j;
        }
    }

    // Update image container ids
    imgContainers = document.getElementsByClassName("room-img");
    for (var i = 0; i < imgContainers.length; i++) {
        imgContainers[i].id = "imgfileInput" + i;
    }
}
function updateImage(input, name) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            var imgContainer = document.getElementById("img" + name);
            imgContainer.style.backgroundImage = "url('" + e.target.result + "')";
            document.getElementsByName("temporaryImgDir" + name[9])[0].value = e.target.result;
            // name[9] = _ of fileInput_ 
        };
        reader.readAsDataURL(input.files[0]);
    }
}

function updatePrices(form)
{
    document.getElementById("action").value = "Update Cart";
    form.submit();
}

//var counter = null;
//function updateCounter()
//{
//    if(counter == null) counter = 2; 
//    else counter++;
//
//}
//function updateJourneys()
//{
//    updateCounter();
//    
//    // Append more journey
//    var original = document.getElementById("default-journey");
//    var journeyContainer = original.cloneNode(true);
//    var journeyParent = document.getElementById("journey-parent");
//    journeyParent.appendChild(journeyContainer);
//    
//    // Change # Journey
//    var journeySpan = journeyContainer.getElementsByTagName('span');
//    journeySpan[0].innerHTML = counter;
//    
//    // Remove values of new journey input fields and add ID to their names
//    var journeyInputs = journeyContainer.getElementsByTagName('input');
//    for (var i = 0; i < journeyInputs.length; i++) {
//        journeyInputs[i].value = "";
//        journeyInputs[i].name = journeyInputs[i].name + (counter - 1);
//    }
//    var journeyTextAreas = journeyContainer.getElementsByTagName('textarea');
//    for (var i = 0; i < journeyTextAreas.length; i++) {
//        journeyTextAreas[i].value = "";
//        journeyTextAreas[i].name = journeyTextAreas[i].name + (counter - 1);
//    }
//    // Change the number of journeys which will later be sent to controller
//    document.getElementById("numOfJourneys").value = counter;
//    
//}
