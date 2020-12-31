import React, { useState } from "react";

const UrlForm = () => {
  const [url, setUrl] = useState("");
  const [clippedUrl, setClippedUrl] = useState("");

  const urlClipHandler = (e) => {
    e.preventDefault();

    fetch(`http://localhost:8088?url=${url}`, {
      method: "POST",
    })
      .then((response) => response.json())
      .then((data) => setClippedUrl(data.shortUrl));
  };

  return (
    <div>
      <h1>Url Shortener</h1>
      <div className="url-form">
        <form onSubmit={(e) => urlClipHandler(e)}>
          <label htmlFor="">Url</label>
          <br />
          <input
            type="text"
            onChange={(e) => setUrl(e.target.value)}
            value={url}
          />
          <br />
          <button>Clip the Url</button>
        </form>

        <div className="result-url">
          <label>Clipped Url</label>
          <input type="text" value={clippedUrl} />
        </div>
      </div>
    </div>
  );
};

export default UrlForm;
