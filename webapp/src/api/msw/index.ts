import { itemListHandlers } from "./itemList";
import { setupWorker } from "msw/browser";

export const server = setupWorker(...itemListHandlers);
