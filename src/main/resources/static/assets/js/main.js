//import FetchService from './service/FetchService';

/*-- Objects --*/
//const fetchService = new FetchService();
/*-- /Objects --*/

const myForm = document.querySelector("#myForm");
if (myForm) {
  myForm.addEventListener("submit", function(e) {
    console.log("Adding Event Listener on myForm");
    shortenLink(e, this);
  });
}

async function shortenLink(e, form) {
  // 1. Prevent reloading of page
  e.preventDefault();
  // 2. Submit the form
  // 2.1 User Interaction
  // 2.2 Build JSON body
  const jsonFormData = buildJsonFormData(form);
  // 2.3 Build Headers
  const headers = buildHeaders();
  // 2.4 Request & Response
  const response = await performPostHttpRequest('/shortify', headers, jsonFormData);
  console.log(response);
  // 2.5 Inform user of result

  if (response) {
    //window.location = '/success.html'
    document.querySelector("#success-message").innerHTML= "Your shorten link is "+ response.value;
  } else {
    alert('An Error Occurred');
  }
}

function buildHeaders() {
  const headers = {
    "Content-Type": "application/json"
  };
  return headers;
}

function buildJsonFormData(form) {
  const jsonFormData = {};
  for (const pair of new FormData(form)) {
    jsonFormData[pair[0]] = pair[1];
  }
  return jsonFormData;
}

async function performPostHttpRequest(fetchLink, headers, body) {
  if (!fetchLink || !headers || !body) {
    throw new Error("One or more  POST request parameters was not passed");
  }
  try {
    const rawResponse = await fetch(fetchLink, {
      method: "POST",
      headers: headers,
      body: JSON.stringify(body)
    });
    const content = await rawResponse.json();
    return content;
  } catch(err) {
    console.error('Error at fetch POST: '+ err);
    throw err;
  }
}