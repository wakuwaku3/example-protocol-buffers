import { Timestamp } from "@bufbuild/protobuf";
import {
  CatServiceGetResponse,
  CatServiceGetResponseChild,
} from "./proto/cat_pb";
import fetch from "node-fetch";

(async () => {
  const response = await fetch("http://localhost:8080");
  const data = await response.json();
  const res = CatServiceGetResponse.fromJson(data);
  console.log(res);
})();

(async () => {
  const req = new CatServiceGetResponse({
    id: "1",
    name: "tama",
    kind: "mike",
    birthedAt: Timestamp.now(),
    children: [
      new CatServiceGetResponseChild({
        id: "2",
        name: "mugi",
        kind: "mike",
      }),
      new CatServiceGetResponseChild({
        id: "3",
        name: "hana",
        kind: "mike",
      }),
    ],
  });
  console.log(req);
  const json = req.toJsonString();
  console.log(json);

  const response = await fetch("http://localhost:8080", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: json,
  });

  const data = await response.json();
  const res = CatServiceGetResponse.fromJson(data);
  console.log(res);
})();
