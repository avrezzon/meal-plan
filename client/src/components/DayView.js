import {
  AccordionBody,
  AccordionHeader,
  AccordionItem,
  Container,
  Row,
  UncontrolledAccordion,
} from "reactstrap";
import { MealView } from "./MealView";

export const DayView = (props) => {
  const mealTypes = Object.keys(props.meals).map((mealType, index) => (
    <AccordionItem key={`${index}-${mealType}`}>
      <AccordionHeader targetId={index.toString()}>{mealType}</AccordionHeader>
      <AccordionBody accordionId={index.toString()}>
        <Container>
          <Row>
            {/*<MealView meal={props.meals[mealType]}/>*/}
            {props.meals[mealType].map((meal) => (
              <MealView key={`${index}-${mealType}-${meal.type}`} meal={meal} />
            ))}
          </Row>
        </Container>
      </AccordionBody>
    </AccordionItem>
  ));

  return (
    <UncontrolledAccordion defaultOpen={["1", "2"]} stayOpen>
      {mealTypes}
    </UncontrolledAccordion>
  );
};
